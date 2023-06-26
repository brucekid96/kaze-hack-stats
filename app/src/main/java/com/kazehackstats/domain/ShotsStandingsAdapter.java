package com.kazehackstats.domain;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.kazehackstats.R;
import com.kazehackstats.data.Match;
import com.kazehackstats.data.MatchRepository;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ShotsStandingsAdapter extends RecyclerView.Adapter<ShotsStandingsAdapter.MyViewHolder> {
  private List<Match> mMatches;
  private Match match;
  private WeakReference<Context> mContext;
  private OnItemListener mOnitemListener;
  private MatchRepository matchRepository;
  private String team;
  private List<String> mTeams;
  private Set<String> teams = new HashSet<>();

  public interface OnItemListener{
    void onItemClick(int position);
  }
  public ShotsStandingsAdapter(
      Context mContext) {
    // Assign the context to the weak reference
    this.mContext = new WeakReference<>(mContext);

    matchRepository = new MatchRepository(mContext);

    matchRepository.getTeamsThatPlayedAtLeastOneMatch().observe((LifecycleOwner) mContext, new Observer<List<String>>() {
      @Override
      public void onChanged(List<String> teams) {
        mTeams = teams;

        notifyDataSetChanged();
      }
    });
  }


  public void setMatchList(List<Match> matchList) {
    mMatches = matchList;
    notifyDataSetChanged();
    Log.d(TAG, "mMatches List " +mMatches);
  }


  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.standing_item,parent,false);
    return new MyViewHolder(v,mOnitemListener);
  }



  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    Match match = mMatches.get(position);

    String team = mTeams.get(position);
    Log.d(TAG, "List of teams: " + mTeams);


    matchRepository.getMatchesPlayedByTeam(team).observe((LifecycleOwner) mContext.get(), new Observer<Integer>() {
      @Override
      public void onChanged(Integer matchesPlayed) {

        holder.teamName.setText(team);
        holder.matchPlayed.setText(String.valueOf(matchesPlayed));
        holder.position.setText(String.valueOf(holder.getAdapterPosition() + 1));
        Log.d(TAG, "Binding team at position " + holder.getAdapterPosition() + ": " + team);
      }
    });
    // Observe the list of matches ordered by shots winner using the DAO method
    matchRepository.getAllMatchesByShotsWinner().observe((LifecycleOwner) mContext.get(), new Observer<List<Match>>() {
      @Override
      public void onChanged(List<Match> matches) {
        // Find the index of the current match in the list
        int index = matches.indexOf(match);
        // If the match is found, bind the view with its rank
        if (index != -1) {
          holder.winTeam.setText(String.valueOf(index + 1));
        }
      }
    });
  }






  @Override
  public int getItemCount()  {

    return mMatches == null ? 0 : mMatches.size();
  }


  public static class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView position;
    public TextView teamName;
    public TextView matchPlayed;
    public TextView winTeam;
    public TextView averagePerGame;
    public TextView differencePerGame;
    ShotsStandingsAdapter.OnItemListener mOnItemListener;
    private final Context context;
    public LinearLayout container;

    public MyViewHolder(@NonNull View itemView, ShotsStandingsAdapter.OnItemListener onitemListener) {
      super(itemView);
      context = itemView.getContext();
      position = itemView.findViewById(R.id.position);
      teamName = itemView.findViewById(R.id.team_name);
      matchPlayed = itemView.findViewById(R.id.match_played_stats);
      winTeam = itemView.findViewById(R.id.win_stats);
      averagePerGame = itemView.findViewById(R.id.average_game_stats);
      differencePerGame = itemView.findViewById(R.id.difference_game_stats);
      mOnItemListener = onitemListener;


    }
  }
  }







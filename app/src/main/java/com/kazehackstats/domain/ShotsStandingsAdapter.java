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
import com.kazehackstats.data.TeamRepository;
import com.kazehackstats.data.TeamStatLine;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ShotsStandingsAdapter extends RecyclerView.Adapter<ShotsStandingsAdapter.MyViewHolder> {
//  private List<Match> mMatches;
  private List<TeamStatLine>mTeamStatLines;
  private Context mContext;

  public ShotsStandingsAdapter(
      Context mContext) {
    this.mContext = mContext;
  }

  public void setTeamStatLineList(List<TeamStatLine> teamStatLineList) {
    mTeamStatLines = teamStatLineList;
    notifyDataSetChanged();
    Log.d(TAG, "mTeamStatLines List " +mTeamStatLines);
  }


  @NonNull
  @Override
  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.standing_item,parent,false);
    return new MyViewHolder(v);
  }



  @Override
  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    TeamStatLine teamStatLine = mTeamStatLines.get(position);
    holder.position.setText(String.valueOf(position + 1));
    holder.teamName.setText(teamStatLine.getTeam());
    holder.matchPlayed.setText(String.valueOf(teamStatLine.getMatchesPlayed()));
    holder.winTeam.setText(String.valueOf(teamStatLine.getWins()));
    holder.averagePerGame.setText(String.valueOf(teamStatLine.getAverageCount()));
    holder.differencePerGame.setText(String.valueOf(teamStatLine.getAverageDifference()));
    Log.d(TAG, "List of teams: " + teamStatLine);

  }






  @Override
  public int getItemCount()  {

    return mTeamStatLines == null ? 0 : mTeamStatLines.size();
  }


  public static class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView position;
    public TextView teamName;
    public TextView matchPlayed;
    public TextView winTeam;
    public TextView averagePerGame;
    public TextView differencePerGame;
    public LinearLayout container;

    public MyViewHolder(@NonNull View itemView) {
      super(itemView);
      position = itemView.findViewById(R.id.position);
      teamName = itemView.findViewById(R.id.team_name);
      matchPlayed = itemView.findViewById(R.id.match_played_stats);
      winTeam = itemView.findViewById(R.id.win_stats);
      averagePerGame = itemView.findViewById(R.id.average_game_stats);
      differencePerGame = itemView.findViewById(R.id.difference_game_stats);


    }
  }
  }







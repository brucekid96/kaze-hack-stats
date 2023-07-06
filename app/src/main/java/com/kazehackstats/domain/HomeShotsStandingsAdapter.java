package com.kazehackstats.domain;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kazehackstats.R;
import com.kazehackstats.data.TeamStatLine;

import java.util.List;

public class HomeShotsStandingsAdapter extends RecyclerView.Adapter<HomeShotsStandingsAdapter.MyViewHolder> {
  //  private List<Match> mMatches;
  private List<TeamStatLine> mTeamStatLines;
  private Context mContext;

  public HomeShotsStandingsAdapter(
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
  public HomeShotsStandingsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.standing_item,parent,false);
    return new HomeShotsStandingsAdapter.MyViewHolder(v);
  }



  @Override
  public void onBindViewHolder(@NonNull HomeShotsStandingsAdapter.MyViewHolder holder, int position) {

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

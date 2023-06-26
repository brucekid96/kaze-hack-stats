package com.kazehackstats.domain;

import com.kazehackstats.data.Match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleData {
  public static List<Match> getSampleMatches() {


    List<Match> matchList = new ArrayList<>(); // Create an empty list

    matchList.add(new Match("465", "05.06", "Brighton", "Manchester City", 8, 12,
        "Manchester City", 7, 2, 6,
        "Manchester City", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Manchester City", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Manchester City", 3));
        matchList.add(new Match("15485", "05.06", "Brighton", "Manchester united", 8, 12,
        "Manchester united", 4, 2, 6,
        "Manchester united", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Manchester united", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Manchester united", 3));
        matchList.add(new Match("154", "05.06",  "Brighton", "Chelsea", 8, 12,
            "Chelsea", 4, 2, 6,
            "Chelsea", 4, 7, 3, "Brighton",
            4, 24, 13, "Brighton", 11, 7,
            1, "Chelsea", 6, 8, 4, "Brighton",
            4, 5, 7,
            "Chelsea", 3));
        matchList.add(new Match("1545", "05.06", "Brighton", "Totthenham", 8, 12,
            "Totthenham", 4, 2, 6,
            "Totthenham", 4, 7, 3, "Brighton",
            4, 24, 13, "Brighton", 11, 7,
            1, "Totthenham", 6, 8, 4, "Brighton",
            4, 5, 7,
            "Totthenham", 3));
        matchList.add(new Match("79", "05.06",  "Brighton", "Notthingham Forest", 8, 12,
            "Brighton", 9, 2, 6,
            "Brighton", 4, 7, 3, "Brighton",
            4, 24, 13, "Brighton", 11, 7,
            1, "Notthingham Forest", 6, 8, 4, "Brighton",
            4, 5, 7,
            "Notthingham Forest", 3));
        matchList.add(new Match("15387", "05.06",  "Brighton", "Arsenal", 8, 12,
            "Arsenal", 4, 2, 6,
            "Arsenal", 4, 7, 3, "Brighton",
            4, 24, 13, "Brighton", 11, 7,
            1, "Notthingham Forest", 6, 8, 4, "Brighton",
            4, 5, 7,
            "Notthingham Forest", 3));
    matchList.add(new Match("1554387", "05.06",  "Bayern", "Dortmund", 8, 12,
        "Dortmund", 4, 2, 6,
        "Arsenal", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Notthingham Forest", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Notthingham Forest", 3));




return matchList;
}
}

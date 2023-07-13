package com.kazehackstats.domain;

import com.kazehackstats.data.BasketballMatch;
import com.kazehackstats.data.Match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SampleData {
  public static List<Match> getSampleMatches() {


    List<Match> matchList = new ArrayList<>(); // Create an empty list

    matchList.add(new Match("465", "05.06","Premiere League", "Manchester City", "Brighton", 8, 12,
        "Brighton", 7, 2, 6,
        "Manchester City", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Manchester City", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Manchester City", 3));
        matchList.add(new Match("15485", "05.06","Premiere League", "Brighton", "Manchester united", 14, 7,
        "Brighton", 4, 2, 6,
        "Manchester united", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Manchester united", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Manchester united", 3));
        matchList.add(new Match("154", "03.06","Premiere League",  "Chelsea", "Brighton", 10, 16,
            "Brighton", 4, 2, 6,
            "Chelsea", 4, 7, 3, "Brighton",
            4, 24, 13, "Brighton", 11, 7,
            1, "Chelsea", 6, 8, 4, "Brighton",
            4, 5, 7,
            "Chelsea", 3));
        matchList.add(new Match("1545", "02.06","Premiere League", "Brighton", "Totthenham", 9, 15,
            "Totthenham", 4, 2, 6,
            "Totthenham", 4, 7, 3, "Brighton",
            4, 24, 13, "Brighton", 11, 7,
            1, "Totthenham", 6, 8, 4, "Brighton",
            4, 5, 7,
            "Totthenham", 3));
        matchList.add(new Match("79", "01.06","Premiere League",  "Brighton", "Notthingham Forest", 8, 12,
            "Notthingham Forest", 9, 2, 6,
            "Brighton", 4, 7, 3, "Brighton",
            4, 24, 13, "Brighton", 11, 7,
            1, "Notthingham Forest", 6, 8, 4, "Brighton",
            4, 5, 7,
            "Notthingham Forest", 3));
        matchList.add(new Match("15387", "05.06","Premiere League",  "Brighton", "Arsenal", 8, 12,
            "Arsenal", 4, 2, 6,
            "Arsenal", 4, 7, 3, "Brighton",
            4, 24, 13, "Brighton", 11, 7,
            1, "Notthingham Forest", 6, 8, 4, "Brighton",
            4, 5, 7,
            "Notthingham Forest", 3));
    matchList.add(new Match("1554387", "05.06","Bundesliga",  "Bayern", "Dortmund", 6, 5,
        "Bayern", 4, 2, 6,
        "Arsenal", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Notthingham Forest", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Notthingham Forest", 3));
    matchList.add(new Match("554787", "05.06","Premiere League",  "Leicester City", "Burnley", 6, 5,
        "Leicester City", 4, 2, 6,
        "Arsenal", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Notthingham Forest", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Notthingham Forest", 3));
    matchList.add(new Match("1554327", "05.06","La Liga",  "PSG", "Seville", 6, 5,
        "PSG", 4, 2, 6,
        "Arsenal", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Notthingham Forest", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Notthingham Forest", 3));
    matchList.add(new Match("14367", "05.05","Ligue1",  "Lyon", "Marseille", 6, 5,
        "Lyon", 4, 2, 6,
        "Arsenal", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Notthingham Forest", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Notthingham Forest", 3));
    matchList.add(new Match("64684", "05.05","Serie A",  "Fiorentina", "As Roma", 6, 5,
        "Fiorentina", 4, 2, 6,
        "Arsenal", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Notthingham Forest", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Notthingham Forest", 3));
    matchList.add(new Match("6468", "05.06","Liga Portugal",  "Sporting Portugal", "Benefica", 14, 5,
        "Sporting Portugal", 4, 2, 6,
        "Arsenal", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Notthingham Forest", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Notthingham Forest", 3));
    matchList.add(new Match("5644387", "05.05","Serie A",  "Fc Porto", "Ac Milan", 6, 5,
        "Fc Porto", 4, 2, 6,
        "Arsenal", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Notthingham Forest", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Notthingham Forest", 3));

    matchList.add(new Match("15687387", "05.05","Premiere League",  "Everton", "Liverpool", 19, 11,
        "Everton", 4, 2, 6,
        "Arsenal", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Notthingham Forest", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Notthingham Forest", 3));
    matchList.add(new Match("87954387", "05.06","Bundesliga",  "Leipzig", "Hoffeinheim", 6, 5,
        "Leipzig", 4, 2, 6,
        "Arsenal", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Notthingham Forest", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Notthingham Forest", 3));
    matchList.add(new Match("178217", "05.05","Bundesliga",  "Bayern Leverkusen", "Union Berlin", 6, 5,
        "Bayern Leverkusen", 4, 2, 6,
        "Arsenal", 4, 7, 3, "Brighton",
        4, 24, 13, "Brighton", 11, 7,
        1, "Notthingham Forest", 6, 8, 4, "Brighton",
        4, 5, 7,
        "Notthingham Forest", 3));


return matchList;
}

  public static List<BasketballMatch> getSampleBasketballMatches() {


    List<BasketballMatch> basketballMatchList = new ArrayList<>(); // Create an empty list

    basketballMatchList.add(new BasketballMatch("895", "05.06","NBA", "Chicago Bulls", "Miami",23 , 18,
        "Chicago Bulls", 5, 7, 11,
        "Miami", 4, 37, 43, "Miami",
        6, 24, 17, "Chicago Bulls", 7));

    basketballMatchList.add(new BasketballMatch("71295", "05.06","EuroLeague", "Barcelona", "Valencia",23 , 18,
        "Barcelona", 5, 7, 11,
        "Valencia", 4, 37, 43, "Valencia",
        6, 24, 17, "Barcelona", 7));

    basketballMatchList.add(new BasketballMatch("811595", "05.06","NBA", "Chicago Bulls", "Memphis Grizlies",13 , 19,
        "Memphis Grizlies", 6, 15, 11,
        "Chicago Bulls", 4, 38, 33, "Chicago Bulls",
        5, 14, 23, "Memphis Grizlies", 9));

    basketballMatchList.add(new BasketballMatch("895", "05.06","NBA", "Denver Nuggets", "Los Angeles Lakers",23 , 28,
        "Los Angeles Lakers", 5, 9, 11,
        "Los Angeles Lakers", 2, 47, 41, "Denver Nuggets",
        6, 24, 17, "Denver Nuggets", 7));

    return basketballMatchList;
  }
}

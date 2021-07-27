package view;

import domain.Car;

import java.util.List;

public class ResultView {

    public static void racingView(List<Car> players) {
        StringBuffer sb = new StringBuffer();
        for(Car plalyer : players) {
            setPlayerView(sb, plalyer);
        }
        System.out.println(sb.toString());
    }

    public static void setPlayerView(StringBuffer sb, Car car) {
        for (int distance = 0; distance < car.checkCarMoveDistance(); distance++) {
            sb.append("-");
        }
        sb.append("\r\n");
    }

}

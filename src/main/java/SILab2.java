
import java.util.ArrayList;
import java.util.List;

    class Time {
        int hours;
        int minutes;
        int seconds;

        public Time(int hours, int minutes, int seconds) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        public int getHours() {
            return hours;
        }

        public int getMinutes() {
            return minutes;
        }

        public int getSeconds() {
            return seconds;
        }
    };

    public class SILab2 {

        public List<Integer> function(List<Time> timesList) {
            List<Integer> result = new ArrayList<>(); // A /

            for (int i = 0; i < timesList.size(); i++) { //B
                int hr = timesList.get(i).getHours(); // C
                int min = timesList.get(i).getMinutes(); // C
                int sec = timesList.get(i).getSeconds(); // C
                if (hr < 0 || hr > 24){ // D
                    if (hr < 0){ // E
                        throw new RuntimeException("The hours are smaller than the minimum"); // F
                    }
                    else { // G
                        throw new RuntimeException("The hours are grater than the maximum"); // H
                    }
                }
                else if (hr < 24) {  // I
                    if (min < 0 || min > 59) // J
                        throw new RuntimeException("The minutes are not valid!"); // K
                    else { // L
                        if (sec >= 0 && sec <= 59) //M
                            result.add(hr * 3600 + min * 60 + sec); //N
                        else // O
                            throw new RuntimeException("The seconds are not valid"); //P
                    }
                }
                else if (hr == 24 && min == 0 && sec == 0) { //Q
                    result.add(hr * 3600 + min * 60 + sec); //R
                }
                else { //S
                    throw new RuntimeException("The time is greater than the maximum"); //T
                }
            }
            return result; //U
        }
    }

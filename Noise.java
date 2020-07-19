import java.util.Random;

public class Noise {

    public static float[] GenerateHeightMaps(int layers, int length, float intensity, int min, int max){
        int area = length*length;
        float[] heightMaps = new float[area];

        for (int layer = 0; layer < layers; layer++) {
            for (int index = 0; index < area; index++) {
                if (min < 0) min = -min;

                Random rMin = new Random();
                Random rMax = new Random();
                int newMin = rMin.nextInt(min);
                int newMax = rMax.nextInt(max);

                Random randomIncrease = new Random();
                float newHeight = randomIncrease.nextInt((newMax+1)+(newMin+1));
                heightMaps[index] += ((newHeight-newMin)*intensity)/10;
            }
        }

        return heightMaps;
    }
}
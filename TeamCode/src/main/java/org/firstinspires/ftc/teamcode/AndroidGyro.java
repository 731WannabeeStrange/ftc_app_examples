package org.firstinspires.ftc.teamcode;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by nicholas on 6/12/17.
 */

@TeleOp
public class AndroidGyro extends OpMode {
    private SensorManager sensorManager;
    private Sensor sensor;
    private static final float NS2S = 1.0f / 1000000000.0f;
    private final float[] deltaRotationVector = new float[4];
    private float timestamp;
    private static final double EPSILON = 0.05f;
    private float omegaMagnitude = 0;

    boolean reset_phone = false;
    float angle = 0;
    float deltaX = 0;
    float abs_heading_phone = 0;
    float heading_phone = 0;

    // Create a listener
    SensorEventListener gyroscopeSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            // This timestep's delta rotation to be multiplied by the current rotation
            // after computing it from the gyro sample data.
            if (timestamp != 0) {
                final float dT = (event.timestamp - timestamp) * NS2S;
                // Axis of the rotation sample, not normalized yet.
                float axisX = event.values[0];
                float axisY = event.values[1];
                float axisZ = event.values[2];

                // Calculate the angular speed of the sample
                omegaMagnitude = (float) Math.sqrt(axisX * axisX + axisY * axisY + axisZ * axisZ);

                // Normalize the rotation vector if it's big enough to get the axis
                // (that is, EPSILON should represent your maximum allowable margin of error)
                if (omegaMagnitude > EPSILON) {
                    axisX /= omegaMagnitude;
                    axisY /= omegaMagnitude;
                    axisZ /= omegaMagnitude;
                }

                // Integrate around this axis with the angular speed by the timestep
                // in order to get a delta rotation from this sample over the timestep
                // We will convert this axis-angle representation of the delta rotation
                // into a quaternion before turning it into the rotation matrix.
                float thetaOverTwo = omegaMagnitude * dT / 2.0f;
                float sinThetaOverTwo = (float) Math.sin(thetaOverTwo);
                float cosThetaOverTwo = (float) Math.cos(thetaOverTwo);
                deltaRotationVector[0] = sinThetaOverTwo * axisX;
                deltaRotationVector[1] = sinThetaOverTwo * axisY;
                deltaRotationVector[2] = sinThetaOverTwo * axisZ;
                deltaRotationVector[3] = cosThetaOverTwo;
                //Log.d("x: ", Float.toString(angle));
                angle += 2 * (float) Math.toDegrees(deltaRotationVector[0]);
                deltaX = -2 * (float) Math.toDegrees(deltaRotationVector[0]);
            }
            timestamp = event.timestamp;

            if (reset_phone) {
                angle = 0;
                deltaX = 0;
                abs_heading_phone = 0;
                reset_phone = false;
            }

            heading_phone = angle;

            if (Math.abs(abs_heading_phone + deltaX) > 360) {
                if ((abs_heading_phone + deltaX) > 0) {
                    abs_heading_phone = abs_heading_phone + deltaX - 360;
                } else {
                    abs_heading_phone = abs_heading_phone + deltaX + 360;
                }
            } else {
                abs_heading_phone += deltaX;
            }

        }


        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };

    // Initialize all of the hardware variables
    public void init() {
        // Get the Android context to use to save the file
        Context context = hardwareMap.appContext;

        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(gyroscopeSensorListener, sensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    public void loop() {
        telemetry.addData("gyro", angle);
        telemetry.update();
    }
}
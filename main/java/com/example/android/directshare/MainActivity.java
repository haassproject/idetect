package com.example.android.directshare;
/* Connor D. Lyons Final Year Project UoG 2017/2018 iDetect MainActivity.java */
/* Class Source and Inspired By: https://github.com/googlesamples/android-DirectShare/#readme */

/* Android, Java and Static import declarations */
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.content.Intent.EXTRA_STREAM;
import static com.example.android.directshare.R.id.imgView;

/* Class opening */
public class MainActivity extends Activity {

    /* Private variable declarations - text entry fields,
    text view fields, 'Send Report' button and screenshot '.bmp' declaration */
    private EditText mEditBody3;
    private TextView textView;
    private TextView textView50;
    public TextView textView25; //Hidden HaaSS score - testing purposes
    private static int RESULT_LOAD_IMAGE = 1;
    private Button share; //'Send Report' button variable
    private Bitmap bm;
    private Spinner platformTypeSpinner; //Drop-down list, platform type
    private Spinner platformSpinner; //Drop-down list, platform name

    /* Public variable declarations - 'ImageView' and CSV reading declarations */
    public Uri x;
    public ImageView imageView;
    public File imageFile;
    public Uri working;
    public CSVSample sample; //Read CSV files cell-by-cell
    public String text;
    public String text2;
    public int position3; //Platform type drop-down list position declaration

    /* Methods for activating refresh gesture, 'Change Image' button, actionbar icon, registering text views,
    2 drop-down lists (spinners) and reading latest image in the Android device gallery */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Positioning the actionbar icon on the right-hand-side of the app
        requestWindowFeature(Window.FEATURE_RIGHT_ICON);
        setContentView(R.layout.main);
        setFeatureDrawableResource(Window.FEATURE_RIGHT_ICON, R.drawable.icons8detective100);

        //2 drop-down lists' declarations
        //Source and Inspired By: https://www.mkyong.com/android/android-spinner-drop-down-list-example/
        //Source and Inspired By: http://www.ahotbrew.com/android-dropdown-spinner-example/
        platformTypeSpinner = (Spinner)findViewById(R.id.platformtypespinner);
        platformSpinner = (Spinner)findViewById(R.id.platformspinner);

        /*First drop-down list's options - Instant Messaging, Social Media, Near-Field Communications,
        Email, Cloud Storage, PDF Readers*/
        final ArrayAdapter<CharSequence> platformTypeAdapter = ArrayAdapter.createFromResource(this, R.array.platform_spinner, android.R.layout.simple_spinner_item);
        platformTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Instant messaging spinner - drop-down list 2
        final ArrayAdapter<CharSequence> platformAdapter = ArrayAdapter.createFromResource(this, R.array.im_spinner, android.R.layout.simple_spinner_item);
        platformAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Social media spinner - drop-down list 2
        final ArrayAdapter<CharSequence> platformAdapter2 = ArrayAdapter.createFromResource(this, R.array.sm_spinner, android.R.layout.simple_spinner_item);
        platformAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Near-field communication spinner - drop-down list 2
        final ArrayAdapter<CharSequence> platformAdapter3 = ArrayAdapter.createFromResource(this, R.array.nfc_spinner, android.R.layout.simple_spinner_item);
        platformAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Email spinner - drop-down list 2
        final ArrayAdapter<CharSequence> platformAdapter4 = ArrayAdapter.createFromResource(this, R.array.e_spinner, android.R.layout.simple_spinner_item);
        platformAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Cloud storage spinner - drop-down list 2
        final ArrayAdapter<CharSequence> platformAdapter5 = ArrayAdapter.createFromResource(this, R.array.cl_spinner, android.R.layout.simple_spinner_item);
        platformAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //PDF reader spinner - drop-down list 2
        final ArrayAdapter<CharSequence> platformAdapter6 = ArrayAdapter.createFromResource(this, R.array.pdf_spinner, android.R.layout.simple_spinner_item);
        platformAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Public wi-fi spinner - drop-down list 2
        final ArrayAdapter<CharSequence> platformAdapter7 = ArrayAdapter.createFromResource(this, R.array.public_spinner, android.R.layout.simple_spinner_item);
        platformAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Private wi-fi spinner - drop-down list 2
        final ArrayAdapter<CharSequence> platformAdapter8 = ArrayAdapter.createFromResource(this, R.array.private_spinner, android.R.layout.simple_spinner_item);
        platformAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //E-commerce spinner - drop-down list 2
        final ArrayAdapter<CharSequence> platformAdapter9 = ArrayAdapter.createFromResource(this, R.array.ecommerce_spinner, android.R.layout.simple_spinner_item);
        platformAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //First drop-down list if statements
        platformTypeSpinner.setAdapter(platformTypeAdapter);
        platformTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                position3 = position;
                if (position3 == 0) {
                    //Change to the first, second drop-down list
                    platformSpinner.setAdapter(platformAdapter);
                }
               else if (position3 == 1) {
                    //Change to the second, second drop-down list
                    platformSpinner.setAdapter(platformAdapter2);
                }
                else if (position3 == 2) {
                    //Change to the third, second drop-down list
                    platformSpinner.setAdapter(platformAdapter3);
                }
                else if (position3 == 3) {
                    //Change to the fourth, second drop-down list
                    platformSpinner.setAdapter(platformAdapter4);
                }
                else if (position3 == 4) {
                    //Change to the fifth, second drop-down list
                    platformSpinner.setAdapter(platformAdapter5);
                }
                else if (position3 == 5) {
                    //Change to the sixth, second drop-down list
                    platformSpinner.setAdapter(platformAdapter6);
                }
                else if (position3 == 6) {
                    //Change to the seventh, second drop-down list
                    platformSpinner.setAdapter(platformAdapter7);
                }
                else if (position3 == 7) {
                    //Change to the eighth, second drop-down list
                    platformSpinner.setAdapter(platformAdapter8);
                }
                else if (position3 == 8) {
                    //Change to the ninth, second drop-down list
                    platformSpinner.setAdapter(platformAdapter9);
                }
                //Set first drop-down list in app
                text = platformTypeSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

        platformSpinner.setAdapter(platformTypeAdapter);
        platformSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {
                platformSpinner.setSelection(position1);
                text2 = platformSpinner.getSelectedItem().toString();

                /*If first option of first drop-down list is selected and first option of second drop-down
                list is selected, display Whatsapp's HaaSS score*/
                if (position1 == 0 && position3 == 0) {
                    String sample1 = sample.toString();
                    textView25.setText(sample1);
                }

                /*If first option of first drop-down list is selected and second option of second drop-down
                list is selected, display FB Messenger's HaaSS score*/
              else if (position1 == 1 && position3 == 0) {
                    String sample2 = sample.toString2();
                    textView25.setText(sample2);
                }

                /*If first option of first drop-down list is selected and third option of second drop-down
                list is selected, display SMS's HaaSS score*/
               else if (position1 == 2 && position3 == 0) {
                    String sample3 = sample.toString3();
                    textView25.setText(sample3);
                }

                /*If second option of first drop-down list is selected and first option of second drop-down
                list is selected, display Facebook's HaaSS score*/
               else if (position1 == 0 && position3 == 1) {
                    String sample4 = sample.toString4();
                    textView25.setText(sample4);
                }

                /*If second option of first drop-down list is selected and third option of second drop-down
                list is selected, display Twitter's HaaSS score*/
                else if (position1 == 1 && position3 == 1) {
                    String sample6 = sample.toString6();
                    textView25.setText(sample6);
                }

                /*If third option of first drop-down list is selected and first option of second drop-down
                list is selected, display QR Codes's HaaSS score*/
                else if (position1 == 0 && position3 == 2) {
                    String sample7 = sample.toString7();
                    textView25.setText(sample7);
                }

                /*If third option of first drop-down list is selected and third option of second drop-down
                list is selected, display Contactless (Cards/Mobile)'s HaaSS score*/
                else if (position1 == 1 && position3 == 2) {
                    String sample9 = sample.toString9();
                    textView25.setText(sample9);
                }

                /*If fourth option of first drop-down list is selected and first option of second drop-down
                list is selected, display Gmail's HaaSS score*/
                else if (position1 == 0 && position3 == 3) {
                    String sample10 = sample.toString10();
                    textView25.setText(sample10);
                }

                /*If fourth option of first drop-down list is selected and second option of second drop-down
                list is selected, display Outlook's HaaSS score*/
                else if (position1 == 1 && position3 == 3) {
                    String sample11 = sample.toString11();
                    textView25.setText(sample11);
                }

                /*If fourth option of first drop-down list is selected and third option of second drop-down
                list is selected, display Mail.com's HaaSS score*/
                else if (position1 == 2 && position3 == 3) {
                    String sample12 = sample.toString12();
                    textView25.setText(sample12);
                }

                /*If fourth option of first drop-down list is selected and fourth option of second drop-down
                list is selected, display Android Mail's HaaSS score*/
                else if (position1 == 3 && position3 == 3) {
                    String sample13 = sample.toString13();
                    textView25.setText(sample13);
                }

                /*If fifth option of first drop-down list is selected and first option of second drop-down
                list is selected, display Google Drive's HaaSS score*/
                else if (position1 == 0 && position3 == 4) {
                    String sample14 = sample.toString14();
                    textView25.setText(sample14);
                }

                /*If fifth option of first drop-down list is selected and second option of second drop-down
                list is selected, display Dropbox's HaaSS score*/
                else if (position1 == 1 && position3 == 4) {
                    String sample15 = sample.toString15();
                    textView25.setText(sample15);
                }

                /*If fifth option of first drop-down list is selected and third option of second drop-down
                list is selected, display OneDrive's HaaSS score*/
                else if (position1 == 2 && position3 == 4) {
                    String sample16 = sample.toString16();
                    textView25.setText(sample16);
                }

                /*If sixth option of first drop-down list is selected and first option of second drop-down
                list is selected, display Adobe Reader's HaaSS score*/
                else if (position1 == 0 && position3 == 5) {
                    String sample17 = sample.toString17();
                    textView25.setText(sample17);
                }

                /*If sixth option of first drop-down list is selected and second option of second drop-down
                list is selected, display Google Drive Reader's HaaSS score*/
                else if (position1 == 1 && position3 == 5) {
                    String sample18 = sample.toString18();
                    textView25.setText(sample18);
                }

                /*If sixth option of first drop-down list is selected and third option of second drop-down
                list is selected, display Android Reader's HaaSS score*/
                else if (position1 == 2 && position3 == 5) {
                    String sample19 = sample.toString19();
                    textView25.setText(sample19);
                }

                /*If seventh option of first drop-down list is selected and first option of second drop-down
                list is selected, display Cafe's HaaSS score*/
                else if (position1 == 0 && position3 == 6) {
                    String sample20 = sample.toString20();
                    textView25.setText(sample20);
                }

                /*If seventh option of first drop-down list is selected and second option of second drop-down
                list is selected, display Shopping Centre's HaaSS score*/
                else if (position1 == 1 && position3 == 6) {
                    String sample21 = sample.toString21();
                    textView25.setText(sample21);
                }

                /*If seventh option of first drop-down list is selected and third option of second drop-down
                list is selected, display City Hotspot's HaaSS score*/
                else if (position1 == 2 && position3 == 6) {
                    String sample22 = sample.toString22();
                    textView25.setText(sample22);
                }

                /*If seventh option of first drop-down list is selected and fourth option of second drop-down
                list is selected, display Residential Hotspot's HaaSS score*/
                else if (position1 == 3 && position3 == 6) {
                    String sample23 = sample.toString23();
                    textView25.setText(sample23);
                }

                /*If seventh option of first drop-down list is selected and fifth option of second drop-down
                list is selected, display School/College's HaaSS score*/
                else if (position1 == 4 && position3 == 6) {
                    String sample24 = sample.toString24();
                    textView25.setText(sample24);
                }

                /*If seventh option of first drop-down list is selected and sixth option of second drop-down
                list is selected, display Work's HaaSS score*/
                else if (position1 == 5 && position3 == 6) {
                    String sample25 = sample.toString25();
                    textView25.setText(sample25);
                }

                /*If eighth option of first drop-down list is selected and first option of second drop-down
                list is selected, display Work's HaaSS score*/
                else if (position1 == 0 && position3 == 7) {
                    String sample26 = sample.toString26();
                    textView25.setText(sample26);
                }
                
                /*If eighth option of first drop-down list is selected and second option of second drop-down
                list is selected, display School/College's HaaSS score*/
                else if (position1 == 1 && position3 == 7) {
                    String sample27 = sample.toString27();
                    textView25.setText(sample27);
                }

                /*If ninth option of first drop-down list is selected and first option of second drop-down
                list is selected, display Amazon's HaaSS score*/
                else if (position1 == 0 && position3 == 8) {
                    String sample28 = sample.toString28();
                    textView25.setText(sample28);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        //'Refresh' button declaration
        //Source: https://stackoverflow.com/questions/13023788/how-to-load-an-image-in-image-view-from-gallery
        Button buttonLoadImage2 = (Button) findViewById(R.id.refreshbutton);
        buttonLoadImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                mEditBody3.setText(String.valueOf(""));
                LatestImage();
            }
        });

        //Initialising the 3 core methods of the app
        RegisterViews();
        LatestImage();
        ReadExcelData();

        //Configuration of the 'Change Image' button
        //Source: https://stackoverflow.com/questions/13023788/how-to-load-an-image-in-image-view-from-gallery
        Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
    }

    //Configuration of the text entry field 'Report Details and Action Taken' and 'Send Report' button
    //Source: https://tausiq.wordpress.com/2013/01/19/android-input-field-validation/
    private void RegisterViews() {
        mEditBody3 = (EditText) findViewById(R.id.body3);
        mEditBody3.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validation.hasText(mEditBody3);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        share = (Button) findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkValidation())
                    submitForm();
                else
                    Toast.makeText(MainActivity.this, "'Report Details and Action Taken' field missing", Toast.LENGTH_LONG).show();
            }
        });
    }

   //Reading CSV data from the 'raw' folder
   //Source and Inspired By: https://www.youtube.com/watch?v=i-TqNzUryn8
   private List<CSVSample> ExcelData = new ArrayList<>();
    private void ReadExcelData() {
        InputStream is = getResources().openRawResource(R.raw.reallukequestion);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        try {
            reader.readLine();
            while ( (line = reader.readLine()) != null) {
               Log.d("MyActivity", "Line: " + line);
               String[] tokens = line.split(",");
                sample = new CSVSample();
                  sample.setRainfall(Double.parseDouble(tokens[0]));
                if (tokens[1].length() > 0) {
                  sample.setSunHours(Double.parseDouble(tokens[1]));
                } else {
                  sample.setSunHours(0);
                }
                if (tokens.length >=3 && tokens[2].length() > 0){
                  sample.setSunHours2(Double.parseDouble(tokens[2]));
                } else {
                  sample.setSunHours2(0);
                }
                if (tokens.length >=4 && tokens[3].length() > 0){
                  sample.setSunHours3(Double.parseDouble(tokens[3]));
                } else {
                  sample.setSunHours3(0);
                }
                if (tokens.length >=5 && tokens[4].length() > 0){
                  sample.setSunHours4(Double.parseDouble(tokens[4]));
                } else {
                  sample.setSunHours4(0);
                }
                if (tokens.length >=6 && tokens[5].length() > 0){
                  sample.setSunHours5(Double.parseDouble(tokens[5]));
                } else {
                  sample.setSunHours5(0);
                }
                if (tokens.length >=7 && tokens[6].length() > 0){
                  sample.setSunHours6(Double.parseDouble(tokens[6]));
                } else {
                  sample.setSunHours6(0);
                }
                if (tokens.length >=8 && tokens[7].length() > 0){
                  sample.setSunHours7(Double.parseDouble(tokens[7]));
                } else {
                  sample.setSunHours7(0);
                }
                if (tokens.length >=9 && tokens[8].length() > 0){
                  sample.setSunHours8(Double.parseDouble(tokens[8]));
                } else {
                  sample.setSunHours8(0);
                }
                if (tokens.length >=10 && tokens[9].length() > 0){
                  sample.setSunHours9(Double.parseDouble(tokens[9]));
                } else {
                  sample.setSunHours9(0);
                }
                if (tokens.length >=11 && tokens[10].length() > 0){
                  sample.setSunHours10(Double.parseDouble(tokens[10]));
                } else {
                  sample.setSunHours10(0);
                }
                if (tokens.length >=12 && tokens[11].length() > 0){
                  sample.setSunHours11(Double.parseDouble(tokens[11]));
                } else {
                  sample.setSunHours11(0);
                }
                if (tokens.length >=13 && tokens[12].length() > 0){
                  sample.setSunHours12(Double.parseDouble(tokens[12]));
                } else {
                  sample.setSunHours12(0);
                }
                if (tokens.length >=14 && tokens[13].length() > 0){
                  sample.setSunHours13(Double.parseDouble(tokens[13]));
                } else {
                  sample.setSunHours13(0);
                }
                if (tokens.length >=15 && tokens[14].length() > 0){
                  sample.setSunHours14(Double.parseDouble(tokens[14]));
                } else {
                  sample.setSunHours14(0);
                }
                if (tokens.length >=16 && tokens[15].length() > 0){
                  sample.setSunHours15(Double.parseDouble(tokens[15]));
                } else {
                  sample.setSunHours15(0);
                }
                if (tokens.length >=17 && tokens[16].length() > 0){
                  sample.setSunHours16(Double.parseDouble(tokens[16]));
                } else {
                  sample.setSunHours16(0);
                }
                if (tokens.length >=18 && tokens[17].length() > 0){
                  sample.setSunHours17(Double.parseDouble(tokens[17]));
                } else {
                  sample.setSunHours17(0);
                }
                if (tokens.length >=19 && tokens[18].length() > 0){
                  sample.setSunHours18(Double.parseDouble(tokens[18]));
                } else {
                  sample.setSunHours18(0);
                }
                if (tokens.length >=20 && tokens[19].length() > 0){
                  sample.setSunHours19(Double.parseDouble(tokens[19]));
                } else {
                  sample.setSunHours19(0);
                }
                if (tokens.length >=21 && tokens[20].length() > 0){
                  sample.setSunHours20(Double.parseDouble(tokens[20]));
                } else {
                  sample.setSunHours20(0);
                }
                if (tokens.length >=22 && tokens[21].length() > 0){
                  sample.setSunHours21(Double.parseDouble(tokens[21]));
                } else {
                  sample.setSunHours21(0);
                }
                if (tokens.length >=23 && tokens[22].length() > 0){
                  sample.setSunHours22(Double.parseDouble(tokens[22]));
                } else {
                  sample.setSunHours22(0);
                }
                if (tokens.length >=24 && tokens[23].length() > 0){
                  sample.setSunHours23(Double.parseDouble(tokens[23]));
                } else {
                  sample.setSunHours23(0);
                }
                if (tokens.length >=25 && tokens[24].length() > 0){
                  sample.setSunHours24(Double.parseDouble(tokens[24]));
                } else {
                  sample.setSunHours24(0);
                }
                if (tokens.length >=26 && tokens[25].length() > 0){
                  sample.setSunHours25(Double.parseDouble(tokens[25]));
                } else {
                  sample.setSunHours25(0);
                }
                if (tokens.length >=27 && tokens[26].length() > 0){
                  sample.setSunHours26(Double.parseDouble(tokens[26]));
                } else {
                  sample.setSunHours26(0);
                }
                if (tokens.length >=28 && tokens[27].length() > 0){
                  sample.setSunHours27(Double.parseDouble(tokens[27]));
                } else {
                  sample.setSunHours27(0);
                }
                if (tokens.length >=29 && tokens[28].length() > 0){
                  sample.setSunHours28(Double.parseDouble(tokens[28]));
                } else {
                  sample.setSunHours28(0);
                }
                if (tokens.length >=30 && tokens[29].length() > 0){
                  sample.setSunHours29(Double.parseDouble(tokens[29]));
                } else {
                  sample.setSunHours29(0);
                }
                if (tokens.length >=31 && tokens[30].length() > 0){
                  sample.setSunHours30(Double.parseDouble(tokens[30]));
                } else {
                  sample.setSunHours30(0);
                }
                if (tokens.length >=32 && tokens[31].length() > 0){
                  sample.setSunHours31(Double.parseDouble(tokens[31]));
                } else {
                  sample.setSunHours31(0);
                }
                if (tokens.length >=33 && tokens[32].length() > 0){
                  sample.setSunHours32(Double.parseDouble(tokens[32]));
                } else {
                  sample.setSunHours32(0);
                }
                if (tokens.length >=34 && tokens[33].length() > 0){
                  sample.setSunHours33(Double.parseDouble(tokens[33]));
                } else {
                  sample.setSunHours33(0);
                }
                if (tokens.length >=35 && tokens[34].length() > 0){
                  sample.setSunHours34(Double.parseDouble(tokens[34]));
                } else {
                  sample.setSunHours34(0);
                }
                if (tokens.length >=36 && tokens[35].length() > 0){
                  sample.setSunHours35(Double.parseDouble(tokens[35]));
                } else {
                  sample.setSunHours35(0);
                }
                if (tokens.length >=37 && tokens[36].length() > 0){
                  sample.setSunHours36(Double.parseDouble(tokens[36]));
                } else {
                  sample.setSunHours36(0);
                }
                if (tokens.length >=38 && tokens[37].length() > 0){
                  sample.setSunHours37(Double.parseDouble(tokens[37]));
                } else {
                  sample.setSunHours37(0);
                }
                if (tokens.length >=39 && tokens[38].length() > 0){
                  sample.setSunHours38(Double.parseDouble(tokens[38]));
                } else {
                  sample.setSunHours38(0);
                }
                if (tokens.length >=40 && tokens[39].length() > 0){
                  sample.setSunHours39(Double.parseDouble(tokens[39]));
                } else {
                  sample.setSunHours39(0);
                }
                if (tokens.length >=41 && tokens[40].length() > 0){
                  sample.setSunHours40(Double.parseDouble(tokens[40]));
                } else {
                  sample.setSunHours40(0);
                }
                if (tokens.length >=42 && tokens[41].length() > 0){
                  sample.setSunHours41(Double.parseDouble(tokens[41]));
                } else {
                  sample.setSunHours41(0);
                }
                if (tokens.length >=43 && tokens[42].length() > 0){
                  sample.setSunHours42(Double.parseDouble(tokens[42]));
                } else {
                  sample.setSunHours42(0);
                }
                if (tokens.length >=44 && tokens[43].length() > 0){
                  sample.setSunHours43(Double.parseDouble(tokens[43]));
                } else {
                  sample.setSunHours43(0);
                }
                if (tokens.length >=45 && tokens[44].length() > 0){
                  sample.setSunHours44(Double.parseDouble(tokens[44]));
                } else {
                  sample.setSunHours44(0);
                }
                if (tokens.length >=46 && tokens[45].length() > 0){
                  sample.setSunHours45(Double.parseDouble(tokens[45]));
                } else {
                  sample.setSunHours45(0);
                }
                if (tokens.length >=47 && tokens[46].length() > 0){
                    sample.setSunHours46(Double.parseDouble(tokens[46]));
                } else {
                    sample.setSunHours46(0);
                }
                if (tokens.length >=48 && tokens[47].length() > 0){
                    sample.setSunHours47(Double.parseDouble(tokens[47]));
                } else {
                    sample.setSunHours47(0);
                }
                if (tokens.length >=49 && tokens[48].length() > 0){
                    sample.setSunHours48(Double.parseDouble(tokens[48]));
                } else {
                    sample.setSunHours48(0);
                }
                if (tokens.length >=50 && tokens[49].length() > 0){
                    sample.setSunHours49(Double.parseDouble(tokens[49]));
                } else {
                    sample.setSunHours49(0);
                }
                if (tokens.length >=51 && tokens[50].length() > 0){
                    sample.setSunHours50(Double.parseDouble(tokens[50]));
                } else {
                    sample.setSunHours50(0);
                }
                if (tokens.length >=52 && tokens[51].length() > 0){
                    sample.setSunHours51(Double.parseDouble(tokens[51]));
                } else {
                    sample.setSunHours51(0);
                }
                if (tokens.length >=53 && tokens[52].length() > 0){
                    sample.setSunHours52(Double.parseDouble(tokens[52]));
                } else {
                    sample.setSunHours52(0);
                }
                if (tokens.length >=54 && tokens[53].length() > 0){
                    sample.setSunHours53(Double.parseDouble(tokens[53]));
                } else {
                    sample.setSunHours53(0);
                }
                if (tokens.length >=55 && tokens[54].length() > 0){
                    sample.setSunHours54(Double.parseDouble(tokens[54]));
                } else {
                    sample.setSunHours54(0);
                }
                if (tokens.length >=56 && tokens[55].length() > 0){
                    sample.setSunHours55(Double.parseDouble(tokens[55]));
                } else {
                    sample.setSunHours55(0);
                }
                if (tokens.length >=57 && tokens[56].length() > 0){
                    sample.setSunHours56(Double.parseDouble(tokens[56]));
                } else {
                    sample.setSunHours56(0);
                }
                if (tokens.length >=58 && tokens[57].length() > 0){
                    sample.setSunHours57(Double.parseDouble(tokens[57]));
                } else {
                    sample.setSunHours57(0);
                }
                if (tokens.length >=59 && tokens[58].length() > 0){
                    sample.setSunHours58(Double.parseDouble(tokens[58]));
                } else {
                    sample.setSunHours58(0);
                }
                if (tokens.length >=60 && tokens[59].length() > 0){
                    sample.setSunHours59(Double.parseDouble(tokens[59]));
                } else {
                    sample.setSunHours59(0);
                }
                if (tokens.length >=61 && tokens[60].length() > 0){
                    sample.setSunHours60(Double.parseDouble(tokens[60]));
                } else {
                    sample.setSunHours60(0);
                }
                if (tokens.length >=62 && tokens[61].length() > 0){
                    sample.setSunHours61(Double.parseDouble(tokens[61]));
                } else {
                    sample.setSunHours61(0);
                }
                if (tokens.length >=63 && tokens[62].length() > 0){
                    sample.setSunHours62(Double.parseDouble(tokens[62]));
                } else {
                    sample.setSunHours62(0);
                }
                if (tokens.length >=64 && tokens[63].length() > 0){
                    sample.setSunHours63(Double.parseDouble(tokens[63]));
                } else {
                    sample.setSunHours63(0);
                }
                if (tokens.length >=65 && tokens[64].length() > 0){
                    sample.setSunHours64(Double.parseDouble(tokens[64]));
                } else {
                    sample.setSunHours64(0);
                }
                if (tokens.length >=66 && tokens[65].length() > 0){
                    sample.setSunHours65(Double.parseDouble(tokens[65]));
                } else {
                    sample.setSunHours65(0);
                }
                if (tokens.length >=67 && tokens[66].length() > 0){
                    sample.setSunHours66(Double.parseDouble(tokens[66]));
                } else {
                    sample.setSunHours66(0);
                }
                if (tokens.length >=68 && tokens[67].length() > 0){
                    sample.setSunHours67(Double.parseDouble(tokens[67]));
                } else {
                    sample.setSunHours67(0);
                }
                if (tokens.length >=69 && tokens[68].length() > 0){
                    sample.setSunHours68(Double.parseDouble(tokens[68]));
                } else {
                    sample.setSunHours68(0);
                }
                if (tokens.length >=70 && tokens[69].length() > 0){
                    sample.setSunHours69(Double.parseDouble(tokens[69]));
                } else {
                    sample.setSunHours69(0);
                }
                if (tokens.length >=71 && tokens[70].length() > 0){
                    sample.setSunHours70(Double.parseDouble(tokens[70]));
                } else {
                    sample.setSunHours70(0);
                }
                if (tokens.length >=72 && tokens[71].length() > 0){
                    sample.setSunHours71(Double.parseDouble(tokens[71]));
                } else {
                    sample.setSunHours71(0);
                }
                if (tokens.length >=73 && tokens[72].length() > 0){
                    sample.setSunHours72(Double.parseDouble(tokens[72]));
                } else {
                    sample.setSunHours72(0);
                }
                if (tokens.length >=74 && tokens[73].length() > 0){
                    sample.setSunHours73(Double.parseDouble(tokens[73]));
                } else {
                    sample.setSunHours73(0);
                }
                if (tokens.length >=75 && tokens[74].length() > 0){
                    sample.setSunHours74(Double.parseDouble(tokens[74]));
                } else {
                    sample.setSunHours74(0);
                }
                if (tokens.length >=76 && tokens[75].length() > 0){
                    sample.setSunHours75(Double.parseDouble(tokens[75]));
                } else {
                    sample.setSunHours75(0);
                }
                if (tokens.length >=77 && tokens[76].length() > 0){
                    sample.setSunHours76(Double.parseDouble(tokens[76]));
                } else {
                    sample.setSunHours76(0);
                }
                if (tokens.length >=78 && tokens[77].length() > 0){
                    sample.setSunHours77(Double.parseDouble(tokens[77]));
                } else {
                    sample.setSunHours77(0);
                }
                if (tokens.length >=79 && tokens[78].length() > 0){
                    sample.setSunHours78(Double.parseDouble(tokens[78]));
                } else {
                    sample.setSunHours78(0);
                }
                if (tokens.length >=80 && tokens[79].length() > 0){
                    sample.setSunHours79(Double.parseDouble(tokens[79]));
                } else {
                    sample.setSunHours79(0);
                }
                if (tokens.length >=81 && tokens[80].length() > 0){
                    sample.setSunHours80(Double.parseDouble(tokens[80]));
                } else {
                    sample.setSunHours80(0);
                }
                if (tokens.length >=82 && tokens[81].length() > 0){
                    sample.setSunHours81(Double.parseDouble(tokens[81]));
                } else {
                    sample.setSunHours81(0);
                }
                if (tokens.length >=83 && tokens[82].length() > 0){
                    sample.setSunHours82(Double.parseDouble(tokens[82]));
                } else {
                    sample.setSunHours82(0);
                }
                if (tokens.length >=84 && tokens[83].length() > 0){
                    sample.setSunHours83(Double.parseDouble(tokens[83]));
                } else {
                    sample.setSunHours83(0);
                }
                if (tokens.length >=85 && tokens[84].length() > 0){
                    sample.setSunHours84(Double.parseDouble(tokens[84]));
                } else {
                    sample.setSunHours84(0);
                }
                if (tokens.length >=86 && tokens[85].length() > 0){
                    sample.setSunHours85(Double.parseDouble(tokens[85]));
                } else {
                    sample.setSunHours85(0);
                }
                if (tokens.length >=87 && tokens[86].length() > 0){
                    sample.setSunHours86(Double.parseDouble(tokens[86]));
                } else {
                    sample.setSunHours86(0);
                }
                if (tokens.length >=88 && tokens[87].length() > 0){
                    sample.setSunHours87(Double.parseDouble(tokens[87]));
                } else {
                    sample.setSunHours87(0);
                }
                if (tokens.length >=89 && tokens[88].length() > 0){
                    sample.setSunHours88(Double.parseDouble(tokens[88]));
                } else {
                    sample.setSunHours88(0);
                }
                if (tokens.length >=90 && tokens[89].length() > 0){
                    sample.setSunHours89(Double.parseDouble(tokens[89]));
                } else {
                    sample.setSunHours89(0);
                }
                if (tokens.length >=91 && tokens[90].length() > 0){
                    sample.setSunHours90(Double.parseDouble(tokens[90]));
                } else {
                    sample.setSunHours90(0);
                }
                if (tokens.length >=92 && tokens[91].length() > 0){
                    sample.setSunHours91(Double.parseDouble(tokens[91]));
                } else {
                    sample.setSunHours91(0);
                }
                if (tokens.length >=93 && tokens[92].length() > 0){
                    sample.setSunHours92(Double.parseDouble(tokens[92]));
                } else {
                    sample.setSunHours92(0);
                }
                if (tokens.length >=94 && tokens[93].length() > 0){
                    sample.setSunHours93(Double.parseDouble(tokens[93]));
                } else {
                    sample.setSunHours93(0);
                }
                if (tokens.length >=95 && tokens[94].length() > 0){
                    sample.setSunHours94(Double.parseDouble(tokens[94]));
                } else {
                    sample.setSunHours94(0);
                }
                if (tokens.length >=96 && tokens[95].length() > 0){
                    sample.setSunHours95(Double.parseDouble(tokens[95]));
                } else {
                    sample.setSunHours95(0);
                }
                if (tokens.length >=97 && tokens[96].length() > 0){
                    sample.setSunHours96(Double.parseDouble(tokens[96]));
                } else {
                    sample.setSunHours96(0);
                }
                if (tokens.length >=98 && tokens[97].length() > 0){
                    sample.setSunHours97(Double.parseDouble(tokens[97]));
                } else {
                    sample.setSunHours97(0);
                }
                if (tokens.length >=99 && tokens[98].length() > 0){
                    sample.setSunHours98(Double.parseDouble(tokens[98]));
                } else {
                    sample.setSunHours98(0);
                }
                if (tokens.length >=100 && tokens[99].length() > 0){
                    sample.setSunHours99(Double.parseDouble(tokens[99]));
                } else {
                    sample.setSunHours99(0);
                }
                if (tokens.length >=101 && tokens[100].length() > 0){
                    sample.setSunHours100(Double.parseDouble(tokens[100]));
                } else {
                    sample.setSunHours100(0);
                }
                if (tokens.length >=102 && tokens[101].length() > 0){
                    sample.setSunHours101(Double.parseDouble(tokens[101]));
                } else {
                    sample.setSunHours101(0);
                }
                if (tokens.length >=103 && tokens[102].length() > 0){
                    sample.setSunHours102(Double.parseDouble(tokens[102]));
                } else {
                    sample.setSunHours102(0);
                }
                if (tokens.length >=104 && tokens[103].length() > 0){
                    sample.setSunHours103(Double.parseDouble(tokens[103]));
                } else {
                    sample.setSunHours103(0);
                }
                if (tokens.length >=105 && tokens[104].length() > 0){
                    sample.setSunHours104(Double.parseDouble(tokens[104]));
                } else {
                    sample.setSunHours104(0);
                }
                if (tokens.length >=106 && tokens[105].length() > 0){
                    sample.setSunHours105(Double.parseDouble(tokens[105]));
                } else {
                    sample.setSunHours105(0);
                }
                if (tokens.length >=107 && tokens[106].length() > 0){
                    sample.setSunHours106(Double.parseDouble(tokens[106]));
                } else {
                    sample.setSunHours106(0);
                }
                if (tokens.length >=108 && tokens[107].length() > 0){
                    sample.setSunHours107(Double.parseDouble(tokens[107]));
                } else {
                    sample.setSunHours107(0);
                }
                if (tokens.length >=109 && tokens[108].length() > 0){
                    sample.setSunHours108(Double.parseDouble(tokens[108]));
                } else {
                    sample.setSunHours108(0);
                }
                if (tokens.length >=110 && tokens[109].length() > 0){
                    sample.setSunHours109(Double.parseDouble(tokens[109]));
                } else {
                    sample.setSunHours109(0);
                }
                if (tokens.length >=111 && tokens[110].length() > 0){
                    sample.setSunHours110(Double.parseDouble(tokens[110]));
                } else {
                    sample.setSunHours110(0);
                }
                if (tokens.length >=112 && tokens[111].length() > 0){
                    sample.setSunHours111(Double.parseDouble(tokens[111]));
                } else {
                    sample.setSunHours111(0);
                }
                if (tokens.length >=113 && tokens[112].length() > 0){
                    sample.setSunHours112(Double.parseDouble(tokens[112]));
                } else {
                    sample.setSunHours112(0);
                }
                if (tokens.length >=114 && tokens[113].length() > 0){
                    sample.setSunHours113(Double.parseDouble(tokens[113]));
                } else {
                    sample.setSunHours113(0);
                }
                if (tokens.length >=115 && tokens[114].length() > 0){
                    sample.setSunHours114(Double.parseDouble(tokens[114]));
                } else {
                    sample.setSunHours114(0);
                }
                ExcelData.add(sample);
                Log.d("MyActivity", "Just created: " + sample);
                textView25 = (TextView) findViewById(R.id.current_date_time7);
            }
      } catch (IOException e) {
          Log.wtf("MyActivity", "Error reading data file on line " + line, e);
          e.printStackTrace();
      }
      }

    //Initialising the swipe-to-refresh function
    /*Automatically load in the latest image from Android device's local gallery
    Source: https://stackoverflow.com/questions/8337585/get-the-last-picture-taken-by-user
    */
    public void LatestImage() {
        String[] projection = new String[]{
                MediaStore.Images.ImageColumns._ID,
                MediaStore.Images.ImageColumns.DATA,
                MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME,
                MediaStore.Images.ImageColumns.DATE_TAKEN,
                MediaStore.Images.ImageColumns.MIME_TYPE
        };
        final Cursor cursor = getContentResolver()
                .query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null,
                        null, MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC");
        if (cursor.moveToFirst()) {
            final ImageView imageView = (ImageView) findViewById(R.id.imgView);
            String imageLocation = cursor.getString(1);
            imageFile = new File(imageLocation);
            if (imageFile.exists()) {
                bm = BitmapFactory.decodeFile(imageLocation);
                imageView.setImageBitmap(bm);
            }
        }
        //Fetch the current date and time that the image is loaded into the app
        GetCurrentDate();
    }

    //Method for record the current date and time
    //Source and Inspired By: https://stackoverflow.com/questions/2271131/display-the-current-time-and-date-in-an-android-application
    public void GetCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat mdformat1 = new SimpleDateFormat("HH:mm:ss");
        String strDate = "Image Date: " + mdformat.format(calendar.getTime());
        String strTime = "Image Time: " + mdformat1.format(calendar.getTime());
        textView = (TextView) findViewById(R.id.current_date_view);
        textView50 = (TextView) findViewById(R.id.current_date_view1);
        textView.setText(strDate);
        textView50.setText(strTime);
    }

    //Method for opening image gallery in-app, select desired image and display in the image's ImageView
    //Source: https://stackoverflow.com/questions/13023788/how-to-load-an-image-in-image-view-from-gallery
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            x = selectedImage;
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            imageFile = new File(picturePath);
            imageView = (ImageView) findViewById(imgView);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
        //Fetch the current date and time that the image is loaded into the app post gallery selection
        GetCurrentDate();
    }

    //Intents to share the text field and image entries via Google Mail
    //Source and Inspired By: https://www.tutorialspoint.com/android/android_sending_email.htm
    private void submitForm() {
        if (checkValidation2() | checkValidation3()) {
            working = Uri.fromFile(imageFile);
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            sharingIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"cl6903b@greenwich.ac.uk"});
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Detection Report");
            sharingIntent.putExtra(EXTRA_STREAM, working);
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,"HaaSS Score: " + textView25.getText().toString() + "\n" + "\n" + "Platform Type: " + text + "\n" + "\n" + "Platform: " + text2 + "\n" + "\n" + "Report Details and Action Taken: " + mEditBody3.getText().toString() + "\n" + "\n" + "Detection Screenshot (Attached) + " + textView.getText().toString() + ", " + textView50.getText().toString());
            /*Automatically open Gmail in Android on 'Send Report' button click
            Source: https://stackoverflow.com/questions/3935009/how-to-open-gmail-compose-when-a-button-is-clicked-in-android-app
            */
            sharingIntent.setPackage("com.google.android.gm");
            startActivity(Intent.createChooser(sharingIntent, getString(R.string.send_intent_title)));
        } else
            Toast.makeText(MainActivity.this, "Image Not Uploaded", Toast.LENGTH_LONG).show();
    }

    //Input validation for the text entry field
    //Source and Inspired By: https://tausiq.wordpress.com/2013/01/19/android-input-field-validation/
    private boolean checkValidation() {
        boolean ret = true;
        if (!Validation.hasText(mEditBody3)) ret = false;
        return ret;
    }

    //Input validation for the ImageView from the chosen gallery image selection
    //Source and Inspired By: https://tausiq.wordpress.com/2013/01/19/android-input-field-validation/
    private boolean checkValidation2() {
        boolean ret2 = true;
        if (x == null) ret2 = false;
        return ret2;
    }

    //Input validation for the automated ImageView gallery selection
    //Source and Inspired By: https://tausiq.wordpress.com/2013/01/19/android-input-field-validation/
    private boolean checkValidation3() {
        boolean ret3 = true;
        if (bm == null) ret3 = false;
        return ret3;
    }

    //Activating the sharing intents when the 'Send Report' button is pressed
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.share:
                    submitForm();
                    break;
            }
        }
    };

    //Activating the sharing intents when the 'Refresh' button is pressed
    private View.OnClickListener mOnClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.refreshbutton:
                    submitForm();
                    break;
            }
        }
    };
}
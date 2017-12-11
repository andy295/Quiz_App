package com.example.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private ExpandableListView expLV;
    private ExpLVAdapter adapter;
    private ArrayList<String> listCategory;
    private Map<String, ArrayList<String>> mapChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expLV = (ExpandableListView) findViewById(R.id.expRules);
        listCategory = new ArrayList<>();
        mapChild = new HashMap<>();

        populateData();
    }


    /**
     * Example of Comment.
     *
     * @param price           of the order
     * @param addWhippedCream is whether or not to add whipped cream to the coffee
     * @param addChocolate    is whether or not to add chocolate to the coffee
     * @param addName         is name of customer
     * @return text summary
     */
    private void populateData() {
        ArrayList<String> listUser = new ArrayList<>();
        ArrayList<String> listGame = new ArrayList<>();
        ArrayList<String> listScore = new ArrayList<>();

        listCategory.add("User");
        listCategory.add("Game");
        listCategory.add("Score");

        listUser.add("Username is mandatory");
        listGame.add("The questions shall be in the form of multiple choice, True / False statement, Specific-answer question etc.");
        listScore.add("5 marks for correct answer and 0 negative marks for wrong answer or empty answer.");

        mapChild.put(listCategory.get(0), listUser);
        mapChild.put(listCategory.get(1), listGame);
        mapChild.put(listCategory.get(2), listScore);

        adapter = new ExpLVAdapter(this, listCategory, mapChild);
        expLV.setAdapter(adapter);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitQuiz(View view) {
        //EditText nameEditText = (EditText) findViewById(R.id.name_edittext);
        //String name = nameEditText.getText().toString();

        //if(name.trim().equals("")) {
          //  Toast.makeText(this, "Name field is empty, please insert your name", Toast.LENGTH_SHORT).show();
        //}
        //else {
         /*   // Figure out if the user wants whipped cream topping
            CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
            boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

            // Figure out if the user wants chocolate topping
            CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
            boolean hasChocolate = chocolateCheckBox.isChecked();

            // Calculate the price
            int price = calculatePrice(hasWhippedCream, hasChocolate);


            //Display the order summary on the screen
            String message = createOrderSummary(price, hasWhippedCream, hasChocolate, name);

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(intent.EXTRA_SUBJECT, getString(R.string.subject_name, name));
            intent.putExtra(intent.EXTRA_TEXT, message);

            if (intent.resolveActivity(getPackageManager()) != null)
                startActivity(intent);

            //displayMessage(message);*/
     //   }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        /*TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);*/
    }
}
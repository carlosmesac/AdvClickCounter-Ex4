package es.ulpgc.eite.cleancode.advclickcounter.clicks;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import es.ulpgc.eite.cleancode.advclickcounter.R;
import es.ulpgc.eite.cleancode.advclickcounter.data.ClickData;

public class ClickListActivity
    extends AppCompatActivity implements ClickListContract.View {

  public static String TAG = ClickListActivity.class.getSimpleName();

  private ClickListContract.Presenter presenter;

  private FloatingActionButton addButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_click);
    getSupportActionBar().setTitle(R.string.app_name);

    // do the setup
    ClickListScreen.configure(this);
    initLayout();
    if (savedInstanceState == null) {
      presenter.onStart();

    } else {
      presenter.onRestart();
    }
    addButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.onClickButtonPressed();
      }
    });
  }

  private void initLayout(){
    addButton = findViewById(R.id.clickButton);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // load the data
    presenter.onResume();
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();

    presenter.onBackPressed();
  }

  @Override
  protected void onPause() {
    super.onPause();

    presenter.onPause();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    presenter.onDestroy();
  }

  @Override
  public void onDataUpdated(ClickListViewModel viewModel) {
    //Log.e(TAG, "onDataUpdated()");

    // deal with the datasource
    ((ListView) findViewById(R.id.clickList)).setAdapter(new ClickListAdapter(
            this, viewModel.datasource, new View.OnClickListener() {

          @Override
          public void onClick(View view) {
            ClickData data = (ClickData) view.getTag();
            data.value++;
            TextView value = view.findViewById(R.id.value);
            value.setText(data.value.toString());
          }
        })
    );
  }

  @Override
  public void injectPresenter(ClickListContract.Presenter presenter) {
    this.presenter = presenter;
  }

  public void onClickButtonPressed(View view) {
    presenter.onClickButtonPressed();
  }
}

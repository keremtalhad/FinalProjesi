package mustafa.muhammedi.saytahmini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    MaterialToolbar materialToolbar;
    FrameLayout frameLayout;
    NavigationView navigationView;
    Button btn_asla;
    RadioButton radio_kolay,radio_orta,radio_zor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        tamamla();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawerLayout, materialToolbar, R.string.drawer_close, R.string.drawer_open);
        drawerLayout.addDrawerListener(toggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.home) {
                    recreate();
                    Toast.makeText(MainActivity.this, "ANASAYFA", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (menuItem.getItemId() == R.id.kolay) {

                    Intent i = new Intent(MainActivity.this,Kolay.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "Kolay Seviye", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (menuItem.getItemId() == R.id.orta) {
                    Intent i = new Intent(MainActivity.this,Orta.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "Orta Seviye", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (menuItem.getItemId() == R.id.zor) {
                    Intent i = new Intent(MainActivity.this,Zor.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "Zor Seviye", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (menuItem.getItemId() == R.id.menu_uygulama) {
                    Intent i = new Intent(MainActivity.this,Ugulamah.class);
                    startActivity(i);
                    Toast.makeText(MainActivity.this, "Uygulama Hakkında", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if (menuItem.getItemId() == R.id.menu_cikis) {
                    Toast.makeText(MainActivity.this, "ÇIKIŞ", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);

                    AlertDialog.Builder uyareipenceresi = new AlertDialog.Builder(MainActivity.this);

                    uyareipenceresi.setTitle("Çıkış");
                    uyareipenceresi.setMessage("Çıkış yapılsın mı ? ");

                    uyareipenceresi.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finishAffinity();
                            System.exit(0);
                        }
                    });
                    uyareipenceresi.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    uyareipenceresi.show();
                }
                return false;
            }
        });

        btn_asla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_kolay.isChecked()){
                    Intent kolay = new Intent(MainActivity.this,Kolay.class);
                    startActivity(kolay);
                } else if (radio_orta.isChecked()) {
                    Intent orta = new Intent(MainActivity.this,Orta.class);
                    startActivity(orta);
                } else if (radio_zor.isChecked()) {
                    Intent zor = new Intent(MainActivity.this,Zor.class);
                    startActivity(zor);
                }else {
                    Toast.makeText(MainActivity.this, "Bir Seviye Seçiniz !!!", Toast.LENGTH_LONG).show();
                }

            }
        });




    }
    public void tamamla() {
        drawerLayout = findViewById(R.id.draweLayout);
        materialToolbar = findViewById(R.id.materialToolbar);
        frameLayout = findViewById(R.id.frameLayout);
        navigationView = findViewById(R.id.navigationView);

        btn_asla = findViewById(R.id.btn_asla);

        radio_kolay = findViewById(R.id.radio_kolay);
        radio_orta = findViewById(R.id.radio_orta);
        radio_zor = findViewById(R.id.radio_zor);

    }
}
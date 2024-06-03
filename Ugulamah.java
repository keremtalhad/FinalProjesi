package mustafa.muhammedi.saytahmini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class Ugulamah extends AppCompatActivity {
    DrawerLayout drawerLayout;
    MaterialToolbar materialToolbar;
    FrameLayout frameLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ugulamah);
        tamamla();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                Ugulamah.this, drawerLayout, materialToolbar, R.string.drawer_close, R.string.drawer_open);
        drawerLayout.addDrawerListener(toggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.home) {
                    Intent i = new Intent(Ugulamah.this,MainActivity.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Ugulamah.this, "ANASAYFA", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (menuItem.getItemId() == R.id.kolay) {
                    Intent i = new Intent(Ugulamah.this,Kolay.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Ugulamah.this, "Kolay Seviye", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (menuItem.getItemId() == R.id.orta) {
                    Intent i = new Intent(Ugulamah.this,Orta.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Ugulamah.this, "Orta Seviye", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (menuItem.getItemId() == R.id.zor) {
                    Intent i = new Intent(Ugulamah.this,Zor.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Ugulamah.this, "Zor Seviye", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (menuItem.getItemId() == R.id.menu_uygulama) {
                    Intent i = new Intent(Ugulamah.this,Ugulamah.class);
                    startActivity(i);
                    finish();
                    Toast.makeText(Ugulamah.this, "Uygulama Hakkında", Toast.LENGTH_SHORT).show();
                    recreate();
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else if (menuItem.getItemId() == R.id.menu_cikis) {
                    Toast.makeText(Ugulamah.this, "ÇIKIŞ", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);

                    AlertDialog.Builder uyareipenceresi = new AlertDialog.Builder(Ugulamah.this);

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

    }
    public void tamamla() {
        drawerLayout = findViewById(R.id.draweLayout);
        materialToolbar = findViewById(R.id.materialToolbar);
        frameLayout = findViewById(R.id.frameLayout);
        navigationView = findViewById(R.id.navigationView);


    }
}
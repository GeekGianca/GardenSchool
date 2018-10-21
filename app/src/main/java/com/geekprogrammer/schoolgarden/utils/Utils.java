package com.geekprogrammer.schoolgarden.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.geekprogrammer.schoolgarden.Plant;
import com.geekprogrammer.schoolgarden.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static final List<Plant> list = new ArrayList<Plant>(){{
        add(new Plant("Naranja Agria", "Citrus aurantinium", "Medicinal. Sus hojas actúan como sedantes y sus frutos macerados sirven para combatir enfermedades del hígado y la bilis.", R.drawable.ic_naranjaagria));
        add(new Plant("Guayaba","Psidium guajaba","Medicinal. Las hojas se hacen como té que sirve para la diarrea y la gastritis.", R.drawable.ic_guayaba));
        add(new Plant("Totumo","Crescencia cujete","Medicinal. La pulpa se usa para curar afecciones respiratorias, para reducir la inflamación de la ubre, en expulsión de la placenta, como purgante y para aliviar cólicos.", R.drawable.ic_totumo));
        add(new Plant("Hierva Santa","Chenopodium","Medicinal. Posee beneficios en calorías, vitaminas, proteínas, grasas, carbohidratos.", R.drawable.ic_hiervasanta));
        add(new Plant("Salvia","Salvia Officinalis","Medicinal. Propiedades antisépticas y antibióticas. Su infusión es digestiva, carminativa y anti vomitiva.", R.drawable.ic_salvia));
        add(new Plant("Ultimorrial","Pasiflora viridiflora kunth","Medicinal. Antiséptico, cicatrizante, antibacteriana y antiinflamatoria", R.drawable.ic_ultimorrial));
        add(new Plant("Rosa amapola","Tagetes patula","Medicinal. La fusión de flores y hojas se usa para combatir la conjuntivitis o ceguera en los niños, orzuelos.", R.drawable.ic_rosaamapola));
        add(new Plant("Ruda","Ruta graveolens L.","Medicinal. Estimula el flujo sanguíneo hacia los órganos digestivos y músculos lisos en general. Se usa en el tratamiento del sistema nervioso.", R.drawable.ic_ruda));
        add(new Plant("Artemisa","Ambrosia cumanense","Medicinal. Se usa para curar las infecciones de los intestinos. Ayuda a calmar los dolores de la menstruación.", R.drawable.ic_artemisa));
        add(new Plant("Orégano","Oreganum vulgare","Medicinal. Ayuda con los problemas de estreñimiento, digestión lenta y problemas digestivos en general. ", R.drawable.ic_oregano));
        add(new Plant("Sábila","Aloe vera","Medicinal. Ayuda a tratar infamaciones externas, quemaduras,  cortes y heridas. Picaduras de insectos, llagas, dolores musculares o reumáticos. ", R.drawable.ic_sabila));
        add(new Plant("Llantén","Plantago major","Medicinal. Las hojas de esta planta tienen propiedades de desinfectar los cortes o heridas y favorecer su cicatrización.", R.drawable.ic_llanten));
        add(new Plant("Toronjil","Melissa officinalis","Medicinal. Antiséptico, cicatrizante, tónico, relajante, cardiotónico, para la digestión, y en aromaterapia.", R.drawable.ic_toronjil));
        add(new Plant("Albahaca","Ocimum basilicum","Medicinales. Para combatir la depresión, el insomnio, la jaqueca y el agotamiento. Sirve para la digestión, y además es diurética.", R.drawable.ic_albahaca));
    }};

    public static byte[] getBytes(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }

    public static Bitmap getImage(byte[] data){
        return BitmapFactory.decodeByteArray(data, 0, data.length);
    }
}

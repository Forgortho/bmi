package bmi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class BmiController {

    @FXML private TextField tfTinggi, tfBerat;
    @FXML private RadioButton rbLaki, rbPerempuan;
    @FXML private ToggleGroup tgGender;
    @FXML private Label lblError, lblBmi, lblKategori;

    
    @FXML
    private void hitung() {
        lblError.setText("");
        try {
            cekGender();
            double tinggiCm = bacaAngka(tfTinggi, "Tinggi");
            double beratKg = bacaAngka(tfBerat, "Berat");

            cekRentang("Tinggi", tinggiCm, 100, 250, "cm");
            cekRentang("Berat", beratKg, 20, 300, "kg");

            double bmi = hitungBmi(beratKg, tinggiCm);

            lblBmi.setText(String.format("%.1f", bmi));
            lblKategori.setText(kategoriBmi(bmi));

        } catch (InputTidakValidException e) {
            lblError.setText(e.getMessage());
            lblBmi.setText("-");
            lblKategori.setText("-");
        }
    }

   
    @FXML
    private void reset() {
        tfTinggi.clear();
        tfBerat.clear();
        tgGender.selectToggle(null);
        lblError.setText("");
        lblBmi.setText("-");
        lblKategori.setText("-");
    }

  
    private void cekGender() throws InputTidakValidException {
        if (tgGender.getSelectedToggle() == null) {
            throw new InputTidakValidException("Pilih jenis kelamin dulu.");
        }
    }

    
    private double bacaAngka(TextField tf, String nama) throws InputTidakValidException {
        String teks = tf.getText().trim().replace(',', '.');
        if (teks.isEmpty()) {
            throw new InputTidakValidException(nama + " belum diisi.");
        }
        try {
            double nilai = Double.parseDouble(teks);
            if (Double.isNaN(nilai) || Double.isInfinite(nilai)) {
                throw new NumberFormatException("bukan angka");
            }
            return nilai;
        } catch (NumberFormatException e) {
            throw new InputTidakValidException(nama + " harus berupa angka.", e);
        }
    }

    // Nilai harus berada di rentang wajar
    private void cekRentang(String nama, double nilai, double min, double maks, String satuan)
            throws InputTidakValidException {
        if (nilai < min || nilai > maks) {
            throw new InputTidakValidException(
                    String.format("%s harus %.0f - %.0f %s.", nama, min, maks, satuan));
        }
    }

    
    private double hitungBmi(double beratKg, double tinggiCm) {
        double tinggiM = tinggiCm / 100.0;
        return beratKg / (tinggiM * tinggiM);
    }

    
    private String kategoriBmi(double bmi) {
        if (bmi < 18.5) return "Berat badan kurang";
        if (bmi < 23.0) return "Normal";
        if (bmi < 25.0) return "Berlebih";
        if (bmi < 30.0) return "Obesitas I";
        return "Obesitas II";
    }
}

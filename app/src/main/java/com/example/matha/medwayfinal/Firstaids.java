package com.example.matha.medwayfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Firstaids extends AppCompatActivity implements View.OnClickListener {
    TextView r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstaids);

        r1=(TextView) findViewById(R.id.r1);
        r2=(TextView) findViewById(R.id.r2);
        r3=(TextView) findViewById(R.id.r3);
        r4=(TextView) findViewById(R.id.r4);
        r5=(TextView) findViewById(R.id.r5);
        r6=(TextView) findViewById(R.id.r6);
        r7=(TextView) findViewById(R.id.r7);
        r8=(TextView) findViewById(R.id.r8);
        r9=(TextView) findViewById(R.id.r9);
        r10=(TextView) findViewById(R.id.r10);
        r11=(TextView) findViewById(R.id.r11);
        r12=(TextView) findViewById(R.id.r12);
        r13=(TextView) findViewById(R.id.r13);
        r14=(TextView) findViewById(R.id.r14);
        r15=(TextView) findViewById(R.id.r15);
        r16=(TextView) findViewById(R.id.r16);
        r17=(TextView) findViewById(R.id.r17);
        r18=(TextView) findViewById(R.id.r18);
        r19=(TextView) findViewById(R.id.r19);
        r20=(TextView) findViewById(R.id.r20);
        r1.setOnClickListener(this);
        r2.setOnClickListener(this);
        r3.setOnClickListener(this);
        r4.setOnClickListener(this);
        r5.setOnClickListener(this);
        r6.setOnClickListener(this);
        r7.setOnClickListener(this);
        r8.setOnClickListener(this);
        r9.setOnClickListener(this);
        r10.setOnClickListener(this);
        r11.setOnClickListener(this);
        r12.setOnClickListener(this);
        r13.setOnClickListener(this);
        r14.setOnClickListener(this);
        r15.setOnClickListener(this);
        r16.setOnClickListener(this);
        r17.setOnClickListener(this);
        r18.setOnClickListener(this);
        r19.setOnClickListener(this);
        r20.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.r1:
                Intent intent1=new Intent(Firstaids.this,sym.class);
                intent1.putExtra("id","i1");
                intent1.putExtra("symptom","Shortness of breath\n" +
                        "Chest tightness or pain\n" +
                        "Trouble sleeping caused by shortness of breath, coughing or wheezing\n" +
                        "A whistling or wheezing sound when exhaling (wheezing is a common sign of asthma in children)\n" +
                        "Coughing or wheezing attacks that are worsened by a respiratory virus, such as a cold or the flu");
                startActivity(intent1);
                break;
            case R.id.r2:
                Intent intent2=new Intent(Firstaids.this,sym.class);
                intent2.putExtra("id","i2");
                intent2.putExtra("symptom","Confusion or decreasing alertness.\n" +
                        "Clammy skin.\n" +
                        "Dizziness or light-headedness after an injury.\n" +
                        "Low blood pressure.\n" +
                        "Paleness (pallor)\n" +
                        "Rapid pulse, increased heart rate.\n" +
                        "Shortness of breath.\n" +
                        "Weakness.");
                startActivity(intent2);
                break;
            case R.id.r3:
                Intent intent3=new Intent(Firstaids.this,sym.class);
                intent3.putExtra("id","i3");
                intent3.putExtra("symptom","Limping or impaired activity.\n" +
                        "Persistent decreased energy or fatigue.\n" +
                        "Swollen glands (lymph nodes) in the neck, groin or underarms.\n" +
                        "Swelling or stiffness.\n" +
                        "Persistent fever or fever with no clear cause.\n" +
                        "Rash.");
                startActivity(intent3);
                break;
            case R.id.r4:
                Intent intent4=new Intent(Firstaids.this,sym.class);
                intent4.putExtra("id","i4");
                intent4.putExtra("symptom","Blisters.\n" +
                        "Pain (The degree of pain is not related to the severity of the burn, as the most serious burns can be painless.)\n" +
                        "Peeling skin.\n" +
                        "Red skin.\n" +
                        "Shock (Symptoms of shock may include pale and clammy skin, weakness, bluish lips and fingernails, and a drop in alertness.)\n" +
                        "Swelling.\n" +
                        "White or charred skin.");
                startActivity(intent4);
                break;
            case R.id.r5:
                Intent intent5=new Intent(Firstaids.this,sym.class);
                intent5.putExtra("id","i5");
                intent5.putExtra("symptom","chest pressure or tightness.\n" +
                        "back, jaw, or arm pain.\n" +
                        "fatigue.\n" +
                        "lightheadedness.\n" +
                        "dizziness.\n" +
                        "shortness of breath.\n" +
                        "abdominal pain.\n" +
                        "nausea.");
                startActivity(intent5);
                break;
            case R.id.r6:
                Intent intent6=new Intent(Firstaids.this,sym.class);
                intent6.putExtra("id","i6");
                intent6.putExtra("symptom","Bluish skin color.\n" +
                        "Difficulty breathing -- ribs and chest pull inward.\n" +
                        "Loss of consciousness (unresponsiveness) if blockage is not cleared.\n" +
                        "Inability to cry or make much sound.\n" +
                        "Weak, ineffective coughing.\n" +
                        "Soft or high-pitched sounds while inhaling.");
                startActivity(intent6);
                break;
            case R.id.r7:
                Intent intent7=new Intent(Firstaids.this,sym.class);
                intent7.putExtra("id","i7");
                intent7.putExtra("symptom","Swelling or bruising over a bone.\n" +
                        "Deformity of an arm or leg.\n" +
                        "Pain in the injured area that gets worse when the area is moved or pressure is applied.\n" +
                        "Loss of function in the injured area.\n" +
                        "In compound fractures, bone protruding from the skin.");
                startActivity(intent7);
                break;
            case R.id.r8:
                Intent intent8=new Intent(Firstaids.this,sym.class);
                intent8.putExtra("id","i8");
                intent8.putExtra("symptom","pus or fluid oozing from the wound.\n" +
                        "tenderness in areas near the bite.\n" +
                        "loss of sensation around the bite.\n" +
                        "limited use of the finger or hand if the hand was bitten.\n" +
                        "red streaks near the bite.\n" +
                        "swollen lymph nodes.\n" +
                        "fever or chills.\n" +
                        "night sweats.");
                startActivity(intent8);
                break;
            case R.id.r9:
                Intent intent9=new Intent(Firstaids.this,sym.class);
                intent9.putExtra("id","i9");
                intent9.putExtra("symptom","Loss of consciousness for a few seconds to a few minutes.\n" +
                        "No loss of consciousness, but a state of being dazed, confused or disoriented.\n" +
                        "Headache.\n" +
                        "Nausea or vomiting.\n" +
                        "Fatigue or drowsiness.\n" +
                        "Difficulty sleeping.\n" +
                        "Sleeping more than usual.\n" +
                        "Dizziness or loss of balance.");
                startActivity(intent9);
                break;
            case R.id.r10:
                Intent intent10=new Intent(Firstaids.this,sym.class);
                intent10.putExtra("id","i10");
                intent10.putExtra("symptom","Throbbing headache.\n" +
                        "Dizziness and light-headedness.\n" +
                        "Lack of sweating despite the heat.\n" +
                        "Red, hot, and dry skin.\n" +
                        "Muscle weakness or cramps.\n" +
                        "Nausea and vomiting.\n" +
                        "Rapid heartbeat, which may be either strong or weak.\n" +
                        "Rapid, shallow breathing.");
                startActivity(intent10);
                break;
            case R.id.r11:
                Intent intent11=new Intent(Firstaids.this,sym.class);
                intent11.putExtra("id","i11");
                intent11.putExtra("symptom","swelling, which may be concentrated in the affected area or may spread throughout the body.\n" +
                        "redness or rash.\n" +
                        "pain in the affected area or in the muscles.\n" +
                        "itching.");
                startActivity(intent11);
                break;
            case R.id.r12:
                Intent intent12=new Intent(Firstaids.this,sym.class);
                intent12.putExtra("id","i12");
                intent12.putExtra("symptom","Swelling and stiffness.\n" +
                        "Redness and warmth to the touch.\n" +
                        "Weakness or instability.\n" +
                        "Popping or crunching noises.\n" +
                        "Inability to fully straighten the knee.");
                startActivity(intent12);
                break;
            case R.id.r13:
                Intent intent13=new Intent(Firstaids.this,sym.class);
                intent13.putExtra("id","i13");
                intent13.putExtra("symptom","Swelling, bruising, or redness due to the injury.\n" +
                        "Pain at rest.\n" +
                        "Pain when the specific muscle or the joint in relation to that muscle is used.\n" +
                        "Weakness of the muscle or tendons.\n" +
                        "Inability to use the muscle at all.");
                startActivity(intent13);
                break;
            case R.id.r14:
                Intent intent14=new Intent(Firstaids.this,sym.class);
                intent14.putExtra("id","i14");
                intent14.putExtra("symptom","A subungual hematoma (nail bruise) is a collection of blood under the nail. It is usually a red or purple color, which fades to blue over a few weeks. The entire finger or toe throbs and is painful to touch or even move through the air.");
                startActivity(intent14);
                break;
            case R.id.r15:
                Intent intent15=new Intent(Firstaids.this,sym.class);
                intent15.putExtra("id","i15");
                intent15.putExtra("symptom","Blurred vision.\n" +
                        "Confusion and disorientation.\n" +
                        "Difficulty in breathing.\n" +
                        "Drooling.\n" +
                        "Excessive tearing.\n" +
                        "Fever.\n" +
                        "Low blood pressure (hypotension)\n" +
                        "Loss of muscle control and muscle twitching.");
                startActivity(intent15);
                break;
            case R.id.r16:
                Intent intent16=new Intent(Firstaids.this,sym.class);
                intent16.putExtra("id","i16");
                intent16.putExtra("symptom","Resu k likhne hain ");
                startActivity(intent16);
                break;
            case R.id.r17:
                Intent intent17=new Intent(Firstaids.this,sym.class);
                intent17.putExtra("id","i17");
                intent17.putExtra("symptom","Anxiety or agitation/restlessness.\n" +
                        "Bluish lips and fingernails.\n" +
                        "Chest pain.\n" +
                        "Confusion.\n" +
                        "Dizziness, lightheadedness, or faintness.\n" +
                        "Pale, cool, clammy skin.\n" +
                        "Low or no urine output.\n" +
                        "Profuse sweating, moist skin.");
                startActivity(intent17);
                break;
            case R.id.r18:
                Intent intent18=new Intent(Firstaids.this,sym.class);
                intent18.putExtra("id","i18");
                intent18.putExtra("symptom","1- Raised bumps that are red or white.\n" +
                        "2- A rash, which might be painful or itchy.\n" +
                        "3- Scaly or rough skin.\n" +
                        "4- Peeling skin.\n" +
                        "5- Ulcers.\n" +
                        "6- Open sores or lesions.\n" +
                        "7- Dry, cracked skin.\n" +
                        "8- Discolored patches of skin.");
                startActivity(intent18);
                break;
            case R.id.r19:
                Intent intent19=new Intent(Firstaids.this,sym.class);
                intent19.putExtra("id","i19");
                intent19.putExtra("symptom","DOMS usually begins within 6-8 hours after a new activity or a change in activity, and can last up to 24-48 hours after the exercise. The muscle pain is due to inflammation within the muscle, which is one of the main triggers for this muscle soreness.");
                startActivity(intent19);
                break;
            case R.id.r20:
                Intent intent20=new Intent(Firstaids.this,sym.class);
                intent20.putExtra("id","i20");
                intent20.putExtra("symptom","1- Cold or bluish skin.\n" +
                        "2- Abbdominal swelling.\n" +
                        "3- Chest pain.\n" +
                        "4- Cough.\n" +
                        "5- Shortness or lack of breath.\n" +
                        "6- Vomiting.");
                startActivity(intent20);
                break;


        }

    }


}

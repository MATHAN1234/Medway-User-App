package com.example.matha.medwayfinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class remedy extends AppCompatActivity {

    TextView symrem;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        id=getIntent().getStringExtra("id");
        symrem=(TextView) findViewById(R.id.symrem);
        switch(id)
        {
            case "i1":
                symrem.setText("1. Caffeinated tea or coffee:\n" +
                        "The caffeine in black or green tea and coffee can help treat asthma. It works similarly to popular asthma medication theophylline, which opens up the airways. Caffeine has the ability to improve breathing function in people with asthma for up to four hours. So black tea and coffee can help with an asthma attack in an emergency when you’re without your inhaler.");
                break;
            case "i2":
                symrem.setText("1. Apply pressure\n" +
                        "2. Raise the affected area\n" +
                        "3- Applying ice to a wound will constrict the blood vessels, allowing a clot to form more quickly and stop the bleeding.");
                break;
            case "i3":
                symrem.setText("Yogurt. Most yogurts are fortified with vitamin D, and depending on the brand, you could get 30 percent of your daily calcium intake from yogurt.\n" +
                        "Milk. Though it’s a staple in kids’ diets, many adults don’t drink milk. An eight-ounce glass of fat-free milk will provide you with 30 percent of your daily dose of calcium. Buy milk fortified with vitamin D, and you’ll get even more benefits.\n" +
                        "Salmon and Tuna. Not only is it good for your heart, but salmon is also good for your bones! Just three ounces of sockeye salmon contains more than your full daily dose of vitamin D. Tuna is another great source of vitamin D, although it doesn’t contain quite as much as salmon (just about 39 percent of your daily dose).\n" +
                        "Spinach. Don’t skip out on the greens, especially spinach. Just one cup of cooked spinach contains 25 percent of the daily recommended dose of calcium. It also contains plenty of fiber, iron and vitamin A. If you just can’t stomach spinach, make a fruit smoothie and add handful of fresh spinach. You’ll never know it’s there!");
                break;
            case "i4":
                symrem.setText("1. Cool water\n" +
                        "The first thing you should do when you get a minor burn is run cool (not cold) water over the burn area for about 20 minutes. Then wash the burned area with mild soap and water.\n" +
                        "\n" +
                        "2. Cool compresses\n" +
                        "A cool compress or clean wet cloth placed over the burn area helps relieve pain and swelling. You can apply the compress in 5- to 15-minute intervals. Try not to use excessively cold compresses because they may irritate the burn more.\n" +
                        "\n" +
                        "3. Antibiotic ointments\n" +
                        "Antibiotic ointments and creams help prevent infections. Apply an antibacterial ointment to your burn and cover with cling film or a sterile, non-fluffy dressing or cloth.\n" +
                        "\n" +
                        "4. Aloe vera\n" +
                        "Aloe vera is often touted as the “burn plant.” Studies show evidence that aloe vera is effective in healing first- to second-degree burns. Aloe is anti-inflammatory, promotes circulation, and inhibits the growth of bacteria. Apply a layer of pure aloe vera gel taken from the leaf of an aloe vera plant directly to the affected area. If you buy aloe vera in a store, make sure it contains a high percentage of aloe vera and avoid products that have additives, especially coloring and perfumes.\n" +
                        "\n" +
                        "5. Honey\n" +
                        "Honey just got sweeter. Apart from its delicious taste, honey may help heal a minor burn when applied topically. Honey is an anti-inflammatory and naturally anti-bacterial and anti-fungal.\n" +
                        "\n" +
                        "\n" +
                        "\n");
                break;
            case "i5":
                symrem.setText("Almonds: When heart pain occurs after eating, acid reflux or gastroesophageal reflux disease (GERD) may be to blame. Both conditions may cause intense chest pain. Many people claim that eating a handful of almonds or drinking almond milk when heartburn strikes eases symptoms.\n" +
                        "\n" +
                        "Apple cider vinegar: Drinking a tablespoon of apple cider vinegar with a glass of water before meals or when heart pain strikes is another home remedy for acid reflux. There’s little scientific evidence to show that apple cider vinegar eases heartburn. Still, many people swear it works.\n" +
                        "\n" +
                        "Drinking a hot drink: Gas is a common cause of chest pain. A hot or warm drink may help rev up your digestive system and ease gas and bloating. Hot hibiscus tea, in particular, supports digestion and heart health. Research shows hibiscus helps lower blood pressure and reduces cholesterol and triglycerides. Hibiscus is generally recognized as safe to consume.");
                break;
            case "i6":
                symrem.setText("1. Give Back Blows\n" +
                        "Give up to 5 blows between the shoulder blades with the heel of your hand.\n" +
                        "\n" +
                        "2. If Person Is Still Choking, Do Thrusts\n" +
                        "\n" +
                        "If the person is not pregnant or too obese, do abdominal thrusts:\n" +
                        "\n" +
                        "Stand behind the person and wrap your arms around the waist.\n" +
                        "Place your clenched fist just above the person’s navel. Grab your fist with your other hand.\n" +
                        "Quickly pull inward and upward as if trying to lift the person up.\n" +
                        "Perform a total of 5 abdominal thrusts.\n" +
                        "If the blockage is still not dislodged, continue cycles of 5 back blows and 5 abdominal thrusts until the object is coughed up or the person starts to breathe or cough.\n" +
                        "Take the object out of his mouth only if you can see it. Never do a finger sweep unless you can see the object in the person's mouth");
                break;
            case "i7":
                symrem.setText("1. Application Of Ice: Ice is an effective home remedy for bone fracture. You can put crushed ice wrapped in cloth or ice packs on the affected area for 8-10 minutes. Do not apply ice directly as it can cause ice burn. Ice application reduces swelling and pain. In case of bone fracture, it is advisable to apply ice 2-3 times a day.\n" +
                        "\n" +
                        "2. Black Caraway Seed: Black caraway seeds have medicinal properties due to the presence of vital nutrients like zinc, iron, phosphorus, etc. which are good for bone health. Massaging the fractured area with black caraway seed oil for 2-3 times a day for two weeks helps in treating bone fracture.\n" +
                        "3. astor Oil: Castor oil is used for treating several health issues like skin problems, constipation, infections, etc. because of its anti-inflammatory and antibacterial properties. Very few people know that castor oil also helps in nursing bone fracture and other bone-related problems like arthritis. In case of bone fracture, dip cotton cloth in castor oil and wrap it around for two days. You can also use castor oil packs daily.");
                break;
            case "i8":
                symrem.setText("Place a clean towel over the injury to stop any bleeding.\n" +
                        "Try to keep the injured area elevated.\n" +
                        "Wash the bite carefully with soap and water.\n" +
                        "Apply a sterile bandage to the wound.\n" +
                        "Apply antibiotic ointment to the injury every day to prevent infection.");
                break;
            case "i9":
                symrem.setText("To stop any bleeding, apply firm pressure directly over the wound with a clean cloth or bandage for 15 minutes. If the cut is deep and may have penetrated the skull, emergency treatment is needed.\n" +
                        "Check for injuries to other parts of the body, especially if the person has fallen. The alarm of seeing a head injury may cause you to overlook other injuries that need attention.\n" +
                        "Apply ice or cold packs to reduce the swelling. A \"goose egg\" lump may appear anyway, but ice will help ease the pain.");
                break;
            case "i10":
                symrem.setText("Onion Juice: This is one of the best remedies for treating a heat stroke. Lot of Ayurvedic practitioners suggest that this should be the first thing that you must reach out for. Applying onion juice behind the ears and on your chest can help bring down your body temperature. For therapeutic purposes onion juice is more desirable, but you can roast some raw onions with cumin and honey and have it. Raw onions in chutneys or salads can also cool your system./n" +
                        "Buttermilk and Coconut Water:Buttermilk is a good source of probiotics and helps in replenishing your body with essential vitamins and minerals that may be lost due to excessive sweating. Similarly, coconut water rehydrates your body by naturally balancing the electrolytes in your body.");
                break;
            case "i11":
                symrem.setText("Apply an ice pack to a bite or sting for 15 to 20 minutes once an hour for the first 6 hours. When not using ice, keep a cool, wet cloth on the bite or sting for up to 6 hours. Always keep a cloth between your skin and the ice pack. Do not apply ice for longer than 15 to 20 minutes at a time. Do not fall asleep with the ice on your skin.\n" +
                        "Elevate the area of the bite or sting to decrease swelling. " +
                        "After the first 6 hours, if swelling is not present, try applying warmth to the site for comfort.");
                break;
            case "i12":
                symrem.setText("Rest and protect an injured or sore area. Stop, change, or take a break from any activity that may be causing your pain or soreness. When resting, place a small pillow under your knee.\n" +
                        "Ice will reduce pain and swelling. Apply ice or cold packs immediately to prevent or minimize swelling. Apply the ice or cold pack for 10 to 20 minutes, 3 or more times a day." +
                        "Elevate the injured or sore area on pillows while applying ice and anytime you are sitting or lying down. Try to keep the area at or above the level of your heart to help minimize swelling.");
                break;
            case "i13":
                symrem.setText("1. Ice: The quickest and easiest way to heal a pulled muscle is to apply an ice pack on the affected area immediately. The cold will constrict the blood vessels, reducing blood flow to the affected area. This in turn helps reduce inflammation and swelling as well as pain." +
                        "2. Elastic Bandage: You can speed up the healing process of a pulled muscle with the help of an elastic bandage. The bandage will help reduce the amount of stress placed on the muscle, which in turn will alleviate swelling and pain.");

                break;
            case "i14":
                symrem.setText("Apply ice and elevate the injured nail area as soon as possible after the injury.\n" +
                        "Trim a torn or detached nail, and tape the nail in place.\n" +
                        "Try to drain blood from under the nail camera.gif if you have pain. Note: Do not drain blood from under your nail if you have diabetes, peripheral arterial disease, or an immune system problem, or if you think a bone is broken.\n" +
                        "Try soaking your toe and using a small pad of wet cotton to help an ingrown toenail heal on its own.\n" +
                        "Trim a hangnail so you don't tear your skin.\n" +
                        "Take off an artificial nail if you are having problems with it.\n" +
                        "Try gloves or lotions to protect weak, brittle, or splitting nails.\n" +
                        "Watch for any signs of a skin infection around a nail.");
                break;
            case "i15":
                symrem.setText("To make a treatment for poison ivy rash, especially one red with blisters, mix 3 teaspoons baking soda and 1 teaspoon water and apply the paste to the affected areas. When it dries, the baking soda will flake off. If the blisters are oozing, mix 2 teaspoons baking soda in 1 quart (or 1 liter) water and use it to saturate a few sterile gauze pads. Cover the blisters with the wet pads for 10 minutes, four times a day. Do not apply on or near your eyes. (A less potentially messy way to get relief: Soak in a cool bath with 1 cup of baking soda mixed in.) Here are some other brilliant home uses for baking soda.");
                break;
            case "i16":
                symrem.setText("1. Check Responsiveness\n" +
                        "2. Do Chest Compressions\n" +
                        " Place the heel of your hand on the center of the person's chest.\n" +
                        "Place the heel of your other hand on top of your first hand, lacing fingers together.\n" +
                        "Keep arms straight and your shoulders directly over your hands.\n" +
                        "Push hard and fast, compressing chest at least 2 inches.\n" +
                        "Let chest rise completely before pushing down again.\n" +
                        "Compress at least 100 times per minute.");
                break;
            case "i17":
                symrem.setText("Call 911\n" +
                        "\n" +
                        "1. Lay the Person Down, if Possible\n" +
                        "\n" +
                        "Elevate the person's feet about 12 inches unless head, neck, or back is injured or you suspect broken hip or leg bones.\n" +
                        "Do not raise the person's head.\n" +
                        "Turn the person on side if he or she is vomiting or bleeding from the mouth.\n" +
                        "2. Begin CPR, if Necessary\n" +
                        "\n" +
                        "If the person is not breathing or breathing seems dangerously weak:\n" +
                        "\n" +
                        "For a child, start CPR for children.\n" +
                        "For an adult, start adult CPR.\n" +
                        "Continue CPR until help arrives or the person wakes up.");
                break;
            case "i18":
                symrem.setText("1-Clean the Cut\n" +
                        "First wash your hands with soap and water.\n" +
                        "Then rinse the cut or scrape with cool water to remove dirt and debris. Hold the area under running water or pour clean water over it from a cup. Use soap to clean the wound.\n" +
                        "You don't need to use stronger cleaning solutions -- such as hydrogen peroxide, iodine, or rubbing alcohol -- to treat minor cuts and scrapes, as they may irritate the wound. Cool clean water should be fine for cleaning the wound.\n" +
                        "\n" +
                        "2-Stop the Bleeding\n" +
                        "A small amount of blood can help clean out the wound. Smaller cuts and abrasions usually stop bleeding on their own. A cut to the head or hand may bleed more because those areas have a lot of blood vessels.\n" +
                        "To stop the bleeding, gently apply firm, direct pressure using a clean cloth or gauze. Continue to hold the pressure steadily.\n" +
                        "Don’t raise the cloth or gauze to check on the wound, because that could cause the wound to start bleeding again. If blood seeps through the dressing, just put more on top and keep applying pressure.\n" +
                        "If the cut is on your hand or arm, you can help slow the bleeding by raising it above your head.\n" +
                        "If the cut spurts blood or if it doesn’t stop bleeding, get medical help right away.");
                break;
            case "i19":
                symrem.setText("1. Stretch\n" +
                        "2. Foam roll\n" +
                        "3. Massage your sore spots\n" +
                        "4. Eat for rapid recovery.\n" +
                        "5. Get heated\n" +
                        "6. Ice it. ");
                break;
            case "i20":
                symrem.setText("If the Person is Not Breathing, Check Pulse\n" +
                        "\n" +
                        "Check the person's pulse for 10 seconds." +
                        "If There is No Pulse, Start CPR" +
                        "For an adult or child, place the heel of one hand on the center of the chest at the nipple line. You can also push with one hand on top of the other. For an infant, place two fingers on the breastbone.\n" +
                        "For an adult or child, press down about 2 inches. Make sure not to press on ribs. For an infant, press down about 1 and 1/2 inches. Make sure not to press on the end of the breastbone.\n" +
                        "Do 30 chest compressions, at the rate of 100 per minute or more. Let the chest rise completely between pushes.\n" +
                        "Check to see if the person has started breathing.");
                break;
        }
    }
    }


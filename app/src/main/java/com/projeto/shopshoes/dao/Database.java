package com.projeto.shopshoes.dao;

import android.content.Context;
import com.projeto.shopshoes.R;
import com.projeto.shopshoes.model.*;

import java.util.Arrays;
import java.util.List;
public class Database {
    public static List<Sneaker> getSneakers(Context context) {
        return Arrays.asList(
                new Sneaker(1,
                        R.drawable.shoes_01_a,
                        new int[]{R.drawable.shoes_01_b, R.drawable.shoes_01_c, R.drawable.shoes_01_d},
                        "Fresh Foam Cruz",
                        new Brand(R.drawable.ic_new_balance, "New Balance"),
                        true,
                        true,
                        new Rating(42, 5),
                        499.90,
                        new ExtraInfo(
                                4,
                                context.getString(R.string.value_recommended),
                                context.getString(R.string.value_type),
                                context.getString(R.string.value_composition),
                                context.getString(R.string.value_desc)
                        )
                ),
                new Sneaker(2,
                        R.drawable.shoes_02_a,
                        new int[]{R.drawable.shoes_02_b, R.drawable.shoes_02_c, R.drawable.shoes_02_d},
                        "Epic React Flyknit",
                        new Brand(R.drawable.ic_nike, "Nike"),
                        true,
                        false,
                        new Rating(91, 5),
                        699.90,
                        new ExtraInfo(
                                4,
                                context.getString(R.string.value_recommended),
                                context.getString(R.string.value_type),
                                context.getString(R.string.value_composition),
                                context.getString(R.string.value_desc)
                        )
                ),
                new Sneaker(3,
                        R.drawable.shoes_03_a,
                        new int[]{R.drawable.shoes_03_b, R.drawable.shoes_03_c, R.drawable.shoes_03_d},
                        "Supernova",
                        new Brand(R.drawable.ic_adidas, "Adidas"),
                        true,
                        false,
                        new Rating(29, 3),
                        599.99,
                        new ExtraInfo(
                                4,
                                context.getString(R.string.value_recommended),
                                context.getString(R.string.value_type),
                                context.getString(R.string.value_composition),
                                context.getString(R.string.value_desc)
                        )
                ),
                new Sneaker(4,
                        R.drawable.shoes_04_a,
                        new int[]{R.drawable.shoes_04_b, R.drawable.shoes_04_c, R.drawable.shoes_04_d},
                        "GEL-Kenun",
                        new Brand(R.drawable.ic_asics, "Asics"),
                        true,
                        false,
                        new Rating(84, 4),
                        699.90,
                        new ExtraInfo(
                                4,
                                context.getString(R.string.value_recommended),
                                context.getString(R.string.value_type),
                                context.getString(R.string.value_composition),
                                context.getString(R.string.value_desc)
                        )
                ),
                new Sneaker(5,
                        R.drawable.shoes_05_a,
                        new int[]{R.drawable.shoes_05_b, R.drawable.shoes_05_c, R.drawable.shoes_05_d},
                        "Charged Bandit 3",
                        new Brand(R.drawable.ic_under_armour, "UnderArmour"),
                        false,
                        true,
                        new Rating(19, 5),
                        349.90,
                        new ExtraInfo(
                                4,
                                context.getString(R.string.value_recommended),
                                context.getString(R.string.value_type),
                                context.getString(R.string.value_composition),
                                context.getString(R.string.value_desc)
                        )
                ),
                new Sneaker(6,
                        R.drawable.shoes_06_a,
                        new int[]{R.drawable.shoes_06_b, R.drawable.shoes_06_c, R.drawable.shoes_06_d},
                        "Wave Sky",
                        new Brand(R.drawable.ic_mizuno, "Mizuno"),
                        true,
                        true,
                        new Rating(42, 5),
                        749.99,
                        new ExtraInfo(
                                4,
                                context.getString(R.string.value_recommended),
                                context.getString(R.string.value_type),
                                context.getString(R.string.value_composition),
                                context.getString(R.string.value_desc)
                        )
                ));
    }

    public User getUser() {
        return new User(
                "John Doe",
                "john@email.com",
                R.drawable.lamborghini_urus);
    }
}

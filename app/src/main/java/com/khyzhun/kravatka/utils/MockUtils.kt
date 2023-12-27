package com.khyzhun.kravatka.utils

import com.khyzhun.kravatka.domain.models.Notification

object MockUtils {
    fun loadMockNotifications(): List<Notification> {
        return listOf(
            Notification(
                0,
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/golden-retriever-royalty-free-image-506756303-1560962726.jpg?crop=0.672xw:1.00xh;0.166xw,0&resize=640:*",
                "You got discount for this week",
                "We have a good news! You got discount for this week for -10%. To apply this discount use promo code #STAND_WITH_UKRAINE",
                false,
            ),
            Notification(
                1,
                "https://ggsc.s3.amazonaws.com/images/uploads/The_Science-Backed_Benefits_of_Being_a_Dog_Owner.jpg",
                "Your password has been changed",
                "02.11.2022 you sent a request to change your password. Your password was successfully changed, Please let us know if it was not you.",
                true,
            ),
            Notification(
                2,
                "https://www.akc.org/wp-content/uploads/2017/11/Golden-Retriever-Puppy.jpg",
                "Meet a new category",
                "We're pleased to announce that we added a new category \"For party\". Find it out, we're you would love that.",
                false,
            ),
            Notification(
                3,
                "https://www.8newsnow.com/wp-content/uploads/sites/59/2022/08/husky_eyes.jpg?w=1988&h=1440&crop=1",
                "You got discount for this week",
                "We have a good news! You got discount for this week for -10%. To apply this discount use promo code #RUSNI_PIZDA",
                false,
            ),
            Notification(
                4,
                "https://www.thekennelclub.org.uk/media/2465/questions-for-the-breeder-no-credit.jpg?mode=crop&width=800&height=600&rnd=132137840200000000",
                "Your password has been changed",
                "02.11.2022 you sent a request to change your password. Your password was successfully changed, Please let us know if it was not you.",
                true,
            ),
            Notification(
                5,
                "https://kb.rspca.org.au/wp-content/uploads/2021/07/collie-beach-bokeh.jpg",
                "Meet a new category",
                "We're pleased to announce that we added a new category \"For party\". Find it out, we're you would love that.",
                false,
            ),
            Notification(
                6,
                "https://assets.bwbx.io/images/users/iqjWHBFdfxIU/iyRWcdIqVMks/v0/1200x-1.jpg",
                "You got discount for this week",
                "We have a good news! You got discount for this week for -10%. To apply this discount use promo code #RUSNI_PIZDA",
                false,
            ),
            Notification(
                7,
                "https://petsitterfrederick.com/wp-content/uploads/2021/04/5484d9d1eab8ea3017b17e29.jpeg",
                "Your password has been changed",
                "02.11.2022 you sent a request to change your password. Your password was successfully changed, Please let us know if it was not you.",
                false,
            ),
            Notification(
                8,
                "https://www.laanimalservices.com/sites/default/files/2022-09/HOMEPAGE-HERO-MOBILE.png",
                "Meet a new category",
                "We're pleased to announce that we added a new category \"For party\". Find it out, we're you would love that.",
                true,
            ),
            Notification(
                9,
                "https://www.forbes.com/advisor/wp-content/uploads/2021/03/pit-bull-featured.jpg",
                "You got discount for this week",
                "We have a good news! You got discount for this week for -10%. To apply this discount use promo code #RUSNI_PIZDA",
                false,
            )
        )

    }
}

package com.khyzhun.kravatka.utils

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.khyzhun.kravatka.domain.models.Notification
import com.khyzhun.kravatka.domain.models.Product
import com.khyzhun.kravatka.domain.models.ProductDetails
import timber.log.Timber

object MockUtils {

    private const val LOREM_IPSUM_SOURCE = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer sodales laoreet commodo. Phasellus a purus eu risus elementum consequat. Aenean eu elit ut nunc convallis laoreet non ut libero. Suspendisse interdum placerat risus vel ornare. Donec vehicula, turpis sed consectetur ullamcorper, ante nunc egestas quam, ultricies adipiscing velit enim at nunc. Aenean id diam neque. Praesent ut lacus sed justo viverra fermentum et ut sem. Fusce convallis gravida lacinia. Integer semper dolor ut elit sagittis lacinia. Praesent sodales scelerisque eros at rhoncus. Duis posuere sapien vel ipsum ornare interdum at eu quam. Vestibulum vel massa erat. Aenean quis sagittis purus. Phasellus arcu purus, rutrum id consectetur non, bibendum at nibh. Duis nec erat dolor. Nulla vitae consectetur ligula. Quisque nec mi est. Ut quam ante, rutrum at pellentesque gravida, pretium in dui. Cras eget sapien velit. Suspendisse ut sem nec tellus vehicula eleifend sit amet quis velit. Phasellus quis suscipit nisi. Nam elementum malesuada tincidunt. Curabitur iaculis pretium eros, malesuada faucibus leo eleifend a. Curabitur congue orci in neque euismod a blandit libero vehicula."

    fun loadMockNotifications(): List<Notification> {
        return listOf(
            Notification(
                0,
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/golden-retriever-royalty-free-image-506756303-1560962726.jpg?crop=0.672xw:1.00xh;0.166xw,0&resize=640:*",
                "You got discount for this week",
                "We have a good news! You got discount for this week for -10%. To apply this discount use promo code #STAND_WITH_UKRAINE",
                false,
            ), Notification(
                1,
                "https://ggsc.s3.amazonaws.com/images/uploads/The_Science-Backed_Benefits_of_Being_a_Dog_Owner.jpg",
                "Your password has been changed",
                "02.11.2022 you sent a request to change your password. Your password was successfully changed, Please let us know if it was not you.",
                true,
            ), Notification(
                2,
                "https://www.akc.org/wp-content/uploads/2017/11/Golden-Retriever-Puppy.jpg",
                "Meet a new category",
                "We're pleased to announce that we added a new category \"For party\". Find it out, we're you would love that.",
                false,
            ), Notification(
                3,
                "https://www.8newsnow.com/wp-content/uploads/sites/59/2022/08/husky_eyes.jpg?w=1988&h=1440&crop=1",
                "You got discount for this week",
                "We have a good news! You got discount for this week for -10%. To apply this discount use promo code #RUSNI_PIZDA",
                false,
            ), Notification(
                4,
                "https://www.thekennelclub.org.uk/media/2465/questions-for-the-breeder-no-credit.jpg?mode=crop&width=800&height=600&rnd=132137840200000000",
                "Your password has been changed",
                "02.11.2022 you sent a request to change your password. Your password was successfully changed, Please let us know if it was not you.",
                true,
            ), Notification(
                5,
                "https://kb.rspca.org.au/wp-content/uploads/2021/07/collie-beach-bokeh.jpg",
                "Meet a new category",
                "We're pleased to announce that we added a new category \"For party\". Find it out, we're you would love that.",
                false,
            ), Notification(
                6,
                "https://assets.bwbx.io/images/users/iqjWHBFdfxIU/iyRWcdIqVMks/v0/1200x-1.jpg",
                "You got discount for this week",
                "We have a good news! You got discount for this week for -10%. To apply this discount use promo code #RUSNI_PIZDA",
                false,
            ), Notification(
                7,
                "https://petsitterfrederick.com/wp-content/uploads/2021/04/5484d9d1eab8ea3017b17e29.jpeg",
                "Your password has been changed",
                "02.11.2022 you sent a request to change your password. Your password was successfully changed, Please let us know if it was not you.",
                false,
            ), Notification(
                8,
                "https://www.laanimalservices.com/sites/default/files/2022-09/HOMEPAGE-HERO-MOBILE.png",
                "Meet a new category",
                "We're pleased to announce that we added a new category \"For party\". Find it out, we're you would love that.",
                true,
            ), Notification(
                9,
                "https://www.forbes.com/advisor/wp-content/uploads/2021/03/pit-bull-featured.jpg",
                "You got discount for this week",
                "We have a good news! You got discount for this week for -10%. To apply this discount use promo code #RUSNI_PIZDA",
                false,
            )
        )

    }

    fun loadMockProducts(): List<Product> {
        return listOf(
            Product(
                1,
                "Product 1",
                39.99,
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/golden-retriever-royalty-free-image-506756303-1560962726.jpg?crop=0.672xw:1.00xh;0.166xw,0&resize=640:*",
                false
            ),
            Product(
                2,
                "Product 2",
                39.99,
                "https://i.natgeofe.com/n/87908698-fc7a-4ada-ba21-490521df2511/01-domesticated-dog_square.jpg",
                true
            ),
            Product(
                3,
                "Product 3",
                52.85,
                "https://as1.ftcdn.net/v2/jpg/01/03/97/52/1000_F_103975260_sOa1Cq2QNhenLiovsuFo39qRZbi0eXZM.jpg",
                false
            ),
            Product(
                4,
                "Product 4",
                74.42,
                "https://www.8newsnow.com/wp-content/uploads/sites/59/2022/08/husky_eyes.jpg?w=1988&h=1440",
                true
            ),
            Product(
                5,
                "Product 5",
                95.21,
                "https://www.thekennelclub.org.uk/media/2465/questions-for-the-breeder-no-credit.jpg?mode=crop&width=800&height=600&rnd=132137840200000000",
                false
            ),
            Product(
                6,
                "Product 6",
                11.11,
                "https://kb.rspca.org.au/wp-content/uploads/2021/07/collie-beach-bokeh.jpg",
                true
            ),
            Product(
                7,
                "Product 7",
                22.22,
                "https://assets.bwbx.io/images/users/iqjWHBFdfxIU/iyRWcdIqVMks/v0/1200x-1.jpg",
                false
            ),
            Product(
                8,
                "Product 8",
                33.33,
                "https://petsitterfrederick.com/wp-content/uploads/2021/04/5484d9d1eab8ea3017b17e29.jpeg",
                true
            ),
            Product(
                9,
                "Product 9",
                44.44,
                "https://www.laanimalservices.com/sites/default/files/2022-09/HOMEPAGE-HERO-MOBILE.png",
                false
            ),
            Product(
                10,
                "Product 10",
                55.55,
                "https://www.forbes.com/advisor/wp-content/uploads/2021/03/pit-bull-featured.jpg",
                true
            ),
        )
    }

    fun loadMockProductsDetails(): List<ProductDetails> {
        return listOf(
            ProductDetails(
                id = 1,
                title = "Product 1",
                description = LOREM_IPSUM_SOURCE,
                category = "Hooded jacket",
                price = 39.99,
                imageUrls = listOf(
                    "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/golden-retriever-royalty-free-image-506756303-1560962726.jpg?crop=0.672xw:1.00xh;0.166xw,0&resize=640:*",
                    "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/golden-retriever-royalty-free-image-506756303-1560962726.jpg?crop=0.672xw:1.00xh;0.166xw,0&resize=640:*",
                    "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/golden-retriever-royalty-free-image-506756303-1560962726.jpg?crop=0.672xw:1.00xh;0.166xw,0&resize=640:*",
                ),
                isFavourite = false
            ),
            ProductDetails(
                id = 2,
                title = "Product 2",
                description = LOREM_IPSUM_SOURCE,
                category = "Hooded jacket",
                price = 39.99,
                imageUrls = listOf(
                    "https://i.natgeofe.com/n/87908698-fc7a-4ada-ba21-490521df2511/01-domesticated-dog_square.jpg",
                    "https://i.natgeofe.com/n/87908698-fc7a-4ada-ba21-490521df2511/01-domesticated-dog_square.jpg",
                    "https://i.natgeofe.com/n/87908698-fc7a-4ada-ba21-490521df2511/01-domesticated-dog_square.jpg",
                ),
                isFavourite = true
            ),
            ProductDetails(
                id = 3,
                title = "Product 3",
                description = LOREM_IPSUM_SOURCE,
                category = "Hooded jacket",
                price = 52.85,
                imageUrls = listOf(
                    "https://as1.ftcdn.net/v2/jpg/01/03/97/52/1000_F_103975260_sOa1Cq2QNhenLiovsuFo39qRZbi0eXZM.jpg",
                    "https://as1.ftcdn.net/v2/jpg/01/03/97/52/1000_F_103975260_sOa1Cq2QNhenLiovsuFo39qRZbi0eXZM.jpg",
                    "https://as1.ftcdn.net/v2/jpg/01/03/97/52/1000_F_103975260_sOa1Cq2QNhenLiovsuFo39qRZbi0eXZM.jpg",
                ),
                isFavourite = false
            ),
            ProductDetails(
                id = 4,
                title = "Product 4",
                description = LOREM_IPSUM_SOURCE,
                category = "Hooded jacket",
                price = 74.42,
                imageUrls = listOf(
                    "https://www.8newsnow.com/wp-content/uploads/sites/59/2022/08/husky_eyes.jpg?w=1988&h=1440",
                    "https://www.8newsnow.com/wp-content/uploads/sites/59/2022/08/husky_eyes.jpg?w=1988&h=1440",
                    "https://www.8newsnow.com/wp-content/uploads/sites/59/2022/08/husky_eyes.jpg?w=1988&h=1440",
                ),
                isFavourite = true
            ),
            ProductDetails(
                id = 5,
                title = "Product 5",
                description = LOREM_IPSUM_SOURCE,
                category = "Hooded jacket",
                price = 95.21,
                imageUrls = listOf(
                    "https://www.thekennelclub.org.uk/media/2465/questions-for-the-breeder-no-credit.jpg?mode=crop&width=800&height=600&rnd=132137840200000000",
                    "https://www.thekennelclub.org.uk/media/2465/questions-for-the-breeder-no-credit.jpg?mode=crop&width=800&height=600&rnd=132137840200000000",
                    "https://www.thekennelclub.org.uk/media/2465/questions-for-the-breeder-no-credit.jpg?mode=crop&width=800&height=600&rnd=132137840200000000",
                ),
                isFavourite = false
            ),
            ProductDetails(
                id = 6,
                title = "Product 6",
                description = LOREM_IPSUM_SOURCE,
                category = "Hooded jacket",
                price = 11.11,
                imageUrls = listOf(
                    "https://kb.rspca.org.au/wp-content/uploads/2021/07/collie-beach-bokeh.jpg",
                    "https://kb.rspca.org.au/wp-content/uploads/2021/07/collie-beach-bokeh.jpg",
                    "https://kb.rspca.org.au/wp-content/uploads/2021/07/collie-beach-bokeh.jpg",
                ),
                isFavourite = true
            ),
            ProductDetails(
                id = 7,
                title = "Product 7",
                description = LOREM_IPSUM_SOURCE,
                category = "Hooded jacket",
                price = 22.22,
                imageUrls = listOf(
                    "https://assets.bwbx.io/images/users/iqjWHBFdfxIU/iyRWcdIqVMks/v0/1200x-1.jpg",
                    "https://assets.bwbx.io/images/users/iqjWHBFdfxIU/iyRWcdIqVMks/v0/1200x-1.jpg",
                    "https://assets.bwbx.io/images/users/iqjWHBFdfxIU/iyRWcdIqVMks/v0/1200x-1.jpg"
                ),
                isFavourite = false
            ),
            ProductDetails(
                id = 8,
                title = "Product 8",
                description = LOREM_IPSUM_SOURCE,
                category = "Hooded jacket",
                price = 33.33,
                imageUrls = listOf(
                    "https://petsitterfrederick.com/wp-content/uploads/2021/04/5484d9d1eab8ea3017b17e29.jpeg",
                    "https://petsitterfrederick.com/wp-content/uploads/2021/04/5484d9d1eab8ea3017b17e29.jpeg",
                    "https://petsitterfrederick.com/wp-content/uploads/2021/04/5484d9d1eab8ea3017b17e29.jpeg",
                ),
                isFavourite = true
            ),
            ProductDetails(
                id = 9,
                title = "Product 9",
                description = LOREM_IPSUM_SOURCE,
                category = "Hooded jacket",
                price = 44.44,
                imageUrls = listOf(
                    "https://www.laanimalservices.com/sites/default/files/2022-09/HOMEPAGE-HERO-MOBILE.png",
                    "https://www.laanimalservices.com/sites/default/files/2022-09/HOMEPAGE-HERO-MOBILE.png",
                    "https://www.laanimalservices.com/sites/default/files/2022-09/HOMEPAGE-HERO-MOBILE.png",
                ),
                isFavourite = false
            ),
            ProductDetails(
                id = 10,
                title = "Product 10",
                description = LOREM_IPSUM_SOURCE,
                category = "Hooded jacket",
                price = 55.55,
                imageUrls = listOf(
                    "https://www.forbes.com/advisor/wp-content/uploads/2021/03/pit-bull-featured.jpg",
                    "https://www.forbes.com/advisor/wp-content/uploads/2021/03/pit-bull-featured.jpg",
                    "https://www.forbes.com/advisor/wp-content/uploads/2021/03/pit-bull-featured.jpg",
                ),
                isFavourite = true
            ),
        )
    }

    fun loadMockProductDetails(id: Long): ProductDetails {
        return loadMockProductsDetails().first { it.id == id }
    }

    fun loadMockSearchCategories(): List<String> {
        return listOf("All", "Top", "Price", "New")
    }

    fun loadMockProduct(id: Long): Product {
        return loadMockProducts().first { it.id == id }
    }

    fun loadMockCart(): List<Product> {
        return listOf(
            Product(
                2,
                "Product 2",
                39.99,
                "https://i.natgeofe.com/n/87908698-fc7a-4ada-ba21-490521df2511/01-domesticated-dog_square.jpg",
                true
            ),
            Product(
                4,
                "Product 4",
                74.42,
                "https://www.8newsnow.com/wp-content/uploads/sites/59/2022/08/husky_eyes.jpg?w=1988&h=1440",
                true
            ),
            Product(
                6,
                "Product 6",
                11.11,
                "https://kb.rspca.org.au/wp-content/uploads/2021/07/collie-beach-bokeh.jpg",
                true
            ),
            Product(
                8,
                "Product 8",
                33.33,
                "https://petsitterfrederick.com/wp-content/uploads/2021/04/5484d9d1eab8ea3017b17e29.jpeg",
                true
            ),
            Product(
                10,
                "Product 10",
                55.55,
                "https://www.forbes.com/advisor/wp-content/uploads/2021/03/pit-bull-featured.jpg",
                true
            ),
        )
    }

    fun isProductInCart(id: Long): Boolean {
        return loadMockCart().map { it.id }.contains(id)
    }

}

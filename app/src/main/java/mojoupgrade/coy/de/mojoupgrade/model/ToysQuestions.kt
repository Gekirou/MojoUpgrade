package mojoupgrade.coy.de.mojoupgrade.model

val toysQuestions = listOf<Question>(
        Question("toys_0"), // use dildo
        Question("toys_1"), // use vibrator
        Question("toys_2", "toys_3", userGenders = arrayOf(Gender.M)), // wear cockring
        Question("toys_3", "toys_2", partnerGenders = arrayOf(Gender.M)), // partner wears cockring
        Question("toys_4", "toys_5"), // wear cockring
        Question("toys_5", "toys_4"), // partner wears cockring
        Question("toys_6", "toys_7"), // wear buttplug
        Question("toys_7", "toys_6"), // partner wears buttplug
        Question("toys_8") // use sex furniture
)

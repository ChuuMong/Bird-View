class Test {
    fun start() {
        val targetHobbies = mutableListOf<String>()
        (0 until getTargetCount()).forEach {
            targetHobbies.add(getTargetHobby())
        }
    }

    private fun getTargetHobby(): String {
        val targetHobby = readLine()!!
        val regex = Text.HOBBY_REGEX.toRegex()
        if (targetHobby.isEmpty() || !regex.matches(targetHobby)) {
            System.out.println(Text.INPUT_NEED_HOBBY)
            return getTargetHobby()
        }

        return targetHobby
    }

    private fun getTargetCount(): Int {
        return try {
            val count = readLine()!!.toInt()
            if (count < 2) {
                System.out.println(Text.INPUT_NEED_TWO_OVER_NUMBER)
                getTargetCount()
            }

            count
        } catch (e: NumberFormatException) {
            System.out.println(Text.INPUT_NEED_NUMBER)
            getTargetCount()
        }
    }
}
fun removeUnwantedChars(s: String): String {
    val stringBuilder = StringBuilder()

    for (value in s.toLowerCase().replace("\n", " ")) {
        if (value in 'a'..'z' || value == '\'') {
            stringBuilder.append(value)
        } else {
            stringBuilder.append(" ")
        }
    }

    return stringBuilder.toString()
}

fun top3(s: String): List<String> {
    val wordsMap = mutableMapOf<String, Int>()

    removeUnwantedChars(s).split(" ").forEach { str ->
        if (str.isNotBlank() && str.contains(Regex("[a-z]"))) {
            wordsMap[str] = wordsMap.getOrDefault(str, -1) + 1
        }
    }

    return wordsMap.toList().sortedByDescending { it.second }.take(3).map { it.first }
}

fun main() {
    println(top3("a a a  b  c c  d d d d  e e e e e"))
    println(top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"))
    println(top3("  //wont won't won't "))
    println(top3("  , e   .. "))
    println(top3("  ...  "))
    println(top3("  '  "))
    println(top3("  '''  "))
    println(
        top3(
            sequenceOf(
                "In a village of La Mancha, the name of which I have no desire to call to",
                "mind, there lived not long since one of those gentlemen that keep a lance",
                "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
                "coursing. An olla of rather more beef than mutton, a salad on most",
                "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
                "on Sundays, made away with three-quarters of his income."
            ).joinToString("\n")
        )
    )
    println(
        top3(
            "vnYbdhgRAk wfwgx fuxNNNPi?Yes wfwgx AdyG;glVWVytkl gFni JKB'N.glVWVytkl,JKB'N;gFni glVWVytkl AdyG:wfwgx!Yes AdyG.rst Yes gFni_wfwgx,gFni gFni rst fuxNNNPi JKB'N!Yes eooO?JKB'N fuxNNNPi LbYl JKB'N JKB'N JKB'N Yes iAcTYb,glVWVytkl eooO JKB'N:Yes WJxr OOhVItR fuxNNNPi fuxNNNPi,JKB'N JKB'N gFni WJxr Yes-gFni Yes:fuxNNNPi Yes rst gFni wfwgx fuxNNNPi vnYbdhgRAk glVWVytkl wfwgx_Yes.fuxNNNPi_gFni-JKB'N,gFni?iAcTYb JKB'N!LbYl gFni/JKB'N!OOhVItR!gFni:fuxNNNPi-gFni JKB'N fuxNNNPi OOhVItR?gFni_Yes_wfwgx:JKB'N;Yes gFni Yes;LbYl-iAcTYb LbYl gFni!LbYl,JKB'N!gFni Yes eooO/Yes;JKB'N wfwgx.JKB'N;gFni:vnYbdhgRAk Yes;Yes-JKB'N JKB'N?Yes wfwgx fuxNNNPi LbYl;gFni wfwgx wfwgx/gFni LbYl!gFni wfwgx!JKB'N,vnYbdhgRAk_OOhVItR-wfwgx glVWVytkl fuxNNNPi,JKB'N,OOhVItR Yes Yes.JKB'N gFni glVWVytkl rst_WJxr/LbYl-JKB'N;wfwgx Yes LbYl Yes_gFni;JKB'N,gFni;OOhVItR JKB'N!OOhVItR iAcTYb wfwgx:wfwgx;fuxNNNPi-iAcTYb iAcTYb fuxNNNPi_iAcTYb;eooO,vnYbdhgRAk iAcTYb Yes rst?fuxNNNPi-apcvz!JKB'N_fuxNNNPi?Yes vnYbdhgRAk?glVWVytkl wfwgx xMPtjogah JKB'N?JKB'N:rst gFni Yes LbYl.gFni!vnYbdhgRAk gFni apcvz!fuxNNNPi:LbYl gFni!xMPtjogah?JKB'N:apcvz"
        )
    )
}
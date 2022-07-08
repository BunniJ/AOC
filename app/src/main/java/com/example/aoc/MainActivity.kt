package com.example.aoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var puzzleInput: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create a new file and write input string
        // Include the input to the puzzle as a hardcoded just to make it easier.
        createPuzzleInputFile()

        // Part 1
        partOne()
    }

    private fun partOne() {
        val puzzleContent = puzzleInput.readLines()

        var syntaxErrScore = 0

        for (content in puzzleContent) {
            val chunkList = arrayListOf<Char>()
            for (illegalChar in content) {
                when(illegalChar) {
                    // setup legal pairs
                    '(' -> chunkList += ')'
                    '[' -> chunkList += ']'
                    '{' -> chunkList += '}'
                    '<' -> chunkList += '>'
                    else -> {
                        if (chunkList.isEmpty()) {
                            break
                        }
                        if (chunkList.removeLast() != illegalChar) {
                            syntaxErrScore += when(illegalChar) {
                                ')' -> 3
                                ']' -> 57
                                '}' -> 1197
                                '>' -> 25137
                                else -> error("Error")
                            }
                            break
                        }
                    }
                }
            }
        }
        println("Total syntax error score of the first puzzle is: $syntaxErrScore")
    }

    private fun createPuzzleInputFile() {
        puzzleInput = File(getExternalFilesDir("")?.absolutePath + "/day_10_input.txt")
        puzzleInput.writeText(
            "{[[((<<[[<[<{(()[])([]{})}({[]<>}{<>()})><{<()[]>>{({}())({}{})}>]>{<{<(<><>)<<>()>><{(){}}<{}>>}(<{{}()}><\n" +
                    "[{{([{[({((<[{<><>}]><<({}())((){})>{[[]]{{}<>}}>){{({{}<>}<{}[]>){{[]()}(<>)}}<[[<><>](<>[])]{{\n" +
                    "[([{<[(<[(((<<{}<>><()<>>>[([]())[{}<>]])[<<<>>[[]<>]>{[<>()]}])[({<{}[]><[]<>>}<(<>[])<()()>>)\n" +
                    "{<({{<<[<{{((<<>{}><{}()>)<<()()>>)}}<<({(()[])[()<>]}([[]<>]))[[<(){}>[[]{}]]<<<>[]>>]>[<[({}\n" +
                    "{[[[([[<(<<(([[]()]<()[]>)[<[][]>{<>}])<({<><>}<{}{}>)[<<>{}>{[][]}]>><({[<><>][<>()]}[((){}]<[][]>]){([<\n" +
                    "[{<[([{{<[<{<{[]()}(()[])>[[[]<>]<[]{}>]}{[{(){}}](<<>[]>{(){}})}>]>}([{[[{([]())<(){}>}<[<>[]\n" +
                    "{(((<{[<{[{<{{[]{}}}{(<>[])<<><>>}>}{({(()())({}[])}([[]{}][[][]]))<<<(){}>[<>{}]><[<>{}]<()[]>\n" +
                    "<(((<<({[<([{([][])<[][]>}[{(){}}{<><>}]]<<{()()}<<><>>>>)><[[({{}()}(()[]))[([]())<<>()>]]]{{{({}())[{}<\n" +
                    "[(({[[[[<(([{<()()>[<>[]]}({()<>}<<>{}>)]){{[<[]()>[[]<>]][(<>[])<{}<>>)}})>]]]]})[({<[{({[[<{<>}(()\n" +
                    "[{<(<<{<<[{<<<<>[]>([][])>>([{[]{}}(()[])]([{}<>](()[])))}]><[({<[{}()]{()[]})(<{}()>{[]{}})}{{[{}()][{}[]]}}\n" +
                    "[<([[<(<{[(([{{}[]}<()[]>][<(){}>{{}[]}])[(<{}{}><<>[]>)<([]()>>])][{{{({}[])([][])}<[<>()]{[]<>}>}{<(()<>)[{\n" +
                    "{({([{<<[[{<[(<><>)<[]{}>]<<()<>>>>[[({}<>)[{}()]]{[{}<>][[][]]}])[({{()[]}<[][]>}{<<><>><{}[]>})\n" +
                    "({<<{[[{([[[<{<>()}[()[]]>{({}())<[]{}>}]<(((){})({}{})){{[]()}({}{})}>]((<({}[])(()())><([]{})(<>(\n" +
                    "{{{(({{{<{<{(<<>[]>[<>()])}[[<{}()>]}>([[<<>()><{}[]>]]{{{<>[]}<[]<>>}{(<>[])[<><>]}})}>}{{(<[{<\n" +
                    "(<{[{<({[[{[(<<>[]>{(){})){[<><>]}][{{{}{}}(<>[])}{[[]<>][<>()]}]}]{[{{(<>[])<<>()>}}[{([]<>){{}[]}}(<<>\n" +
                    "{<([<<{((([([<{}<>>[[]()]]{(()[])(()<>)})<[[()<>][{}{}]]>]({{[[]()](<>{})}{(()[])}}<{<[]{}>{()<>}}[([]()){{}\n" +
                    "(({<<[[({[[<((()()))>({<[]()>{[]())}{[<>()]{(){}}})]<<{[[]<>]<()[]>}({{}[]}[[]{}])>({{{}<>}[<\n" +
                    "[{[(<<<{({<[<{<>()}>[[(){}]{[]()}]][(<<>[]>{<><>})(([]())[[]{}])]>[({{<>{}}}<<(){}>[<>[]}>)({{{\n" +
                    "[{((<<{<[[{{[([]{})[[]()]]<([][]){()}>}{<{<>{}}<()[]>><<<><>>[[][]]>}}[([[<>][<>[]]))(<({}\n" +
                    "((([[[<[({{[{{[]()}}]<<<<>[])[{}()]>>}<[[{{}()}{[]()}]<{<>[]}{()<>}>][[[<>{}][{}[]]]]>}{([(<(){}>([]<>)\n" +
                    "(<{[[({[<((<(<<>[]>[()[]]){<<>[]><{}{}>}>))>]}([[[[[<(()<>)>(((){}){<>()})]<<<[]()>{[]<>}>[[[]\n" +
                    "<[<[([{<{({<[({}<>)<{}<>>]{<<>>}><[<<>[]>{{}<>}]{<(){}><{}{}>}>}){[([<()<>>](<[]<>>))<{({}{})<<>()>}]](\n" +
                    "[[(([<{{({<{{{<><>}(()())}(<{}<>>)}{<{[]()}{()()}>[[()()][{}()]]}>})(<{<[<{}()>([]<>)]{([]<>)}>}>{[<({()[]}<\n" +
                    "(<(({(<[[(((<<<>{}>(<>[])>((()<>)<{}[]>))){[(<<>[]>{[][]})]{[{(){}}[[][]]]{<[][]>}}})]([{((\n" +
                    "[<{{[<(([<[<([<>()]{<>})([{}{}][{}[]>)>(<[{}[]]{[][]}>[{(){}}({}{})])]>([{[[{}[]]][<<>{}>[()<>]]}{[<{}\n" +
                    "({[[{{({[[<<({{}}{[]()})<<<><>>[(){}]>>[<<{}{}>{<>[]}>]>]<[[{[[]]{<>{}}}]{{<<>[]><[]()>}{[{}<>]<()<>>}\n" +
                    "(<<((<[([({[[{{}()}<()<>>]({{}<>>([]()))]<{(()())((){})}{[[]<>]{{}{}}}>}<[[[<>]<<><>>]<[(){}][<>()]>]\n" +
                    "<(({((<(({[{{{{}()}(<>[])}}]{<<[[]{}]([]{})><(()[])[(){}]>>[{(<>()){[]{}}}<<[]<>>[()()]>]}}({[[<\n" +
                    "<{<[[{<{[<{<((<>[])[<>{}])><({{}{}}[()<>])>}([{({}{}){{}[]}}{{<>()}[<>()]}])>{{[[({}[])<{}[]>]\n" +
                    "[[<{(((<[<{<[<[][]><[][]>][([][])]>}({<[{}()]<[]<>>>})>]([<[[([]<>)]<{()<>>>]<{(()())}>>]<[\n" +
                    "<[({([([([<{<<[][]>{{}<>}><<()><<>()>>}{{([]<>){[]{}}}}>[[[[[]][<>[]]]]]]{[{<(()<>)<{}()>>}\n" +
                    "[<[{{({[<<[<(([][]){[]{}})((<>())<()[]>)>({[{}<>](<><>)}<<<><>>[{}()]>)][{<{<>{}}[{}()]>[[{}[]>[(){}]]}(((\n" +
                    "{<{({<[<[({{<{<><>}{{}{}}>[{<><>}<<>{}>]}{{[()<>](<>{})}{<[][]><<>{}>}}})<({(([]()))<<[]{}>{{\n" +
                    "([({<[<{<(<[(<{}{}>{{}<>})[({}[])(<>{})]]([[[][]][{}]])><(([(){}](<>{}))){(<[]<>>[<>{}])}>)][({{((()[])((\n" +
                    "(<{[(<<({{{{[<<><>>{<>[]}]}{{<[][]>[{}<>]}<[{}<>]({}())>}}[{({()()}({}()))[[<>[]][<>[]]]}{<<[]()><<>\n" +
                    "(({((<(<{{[{(([]<>)[{}()])((()[]))}[<([]<>){()<>}>]])[<{({{}[]}({}<>))<[<>()](<>())>}>{<{[{}[]](<>[])}[{[][]\n" +
                    "<[<[<<<<([{{{(()())<[]()>}{[[]<>][<><>]}}(<{()[]}<{}()>><([]{})[{}{}]>)}[[<{[]{}}([]<>)>][[[<><>]<<>{}>]({{}\n" +
                    "<<{((({<[[<[<{<><>}<{}{}>>]>]]{{(<([<>()]{{}})><{{[]{}}{()[]}}[<[]()>[[]]]>)<{{(()[])([]())}[[()[]][\n" +
                    "[{<<<{{{(<<(({<>[]}[{}()])<[[]{}]>)[[[{}[]]{{}()}][([][]){{}[]}]]>>)}}}>>><(((({{<[{([[]<>]{[][]})[<()()>[{}{\n" +
                    "((<[([<[([{{[[{}{}][(){}]](([][])(<><>)>}{<(<>{})(<>{})>}}[(<[()<>]><[{}()](<>())>)<{[[]<>]<(){}\n" +
                    "({{[<<([[<([[<<><>>[[]]]{(<>{}){()<>}}]([{(){}}[(){}]]([[]<>]<{}<>>)))[{([{}[]][{}[]])[(()<>)(<>)]}[\n" +
                    "({[[{<[<[[[<[(<>[])<()>][([]())]><[([]<>)<<>{}>]>]{{({()<>}{(){}})[{<><>}(()[])]}}]({[<{{}()}<()()>>[\n" +
                    "{[<((([[{({[([[][]][[]<>])([[]<>][<>()])]{[[()[]](<><>)]}}{{(<[]()><{}{}>)[<()[]><[][]>)}<{{<><>}{<>[]}\n" +
                    "(([{([[{[([[((<><>)<<>()>)<[[]]>]<([()]<<>{}>)[({}())<<>>]>]((<<<>()>{()()]>{{{}}})[{<<>()>({}())}\n" +
                    "[<<[[<<<(<([[{()[]>[[]()]]([(){}](<><>))]{<{[]{}}((){})>{{[]}[{}]}})>{(<(([][]))({()()})>(<([]<>)({}<>)>)\n" +
                    "<(<(<({({(<<([[]<>]{{}<>})({[][]}[()()])>>{[<<(){}>[{}<>]>{({}{})(<>())}]{<<<>[]><<>()>><{<><>}{()<>}>}})<\n" +
                    "<{<<{[<[([<<[[{}](<>{})]{<(){}>{()()}}><{([]<>)}]>]<{{<{(){}}<<>{}>>}}{{<[[][]][<>{}]><(())({}{})>}[{[\n" +
                    "({(<<<<([<{{{([]{}){(){}}}[[(){}]])[<{<>()}[{}<>]>{<[]>}]}>{[{[[{}{}][{}[]]](<{}[]><()()>)}\n" +
                    "(([{<<[{{<[({<[]>[<>[])}({{}()}{()()}))](<((<><>)[{}[]])<<[]<>>((){})>>({<{}()>}))>{[<([{}<>]<[]<>>)[((){\n" +
                    "{{[[<{[[<<{(<<<>()>{{}]>(<{}[]>([][])))<{[{}{}]{(){}}}([[]{}])>}[{<({}[]){()()}>}[[<()[]>{()<>}]\n" +
                    "{([<<<<[(((<(<{}()>)((()[]){[][]})>{({[]}(()()))[{[][]}[{}{}]]})(<{[()()]([][])}><{(()[])<()<>>}<{(\n" +
                    "((([<<[{{(<(<{[]}<()<>>>(([]())({}())))>)}<[({<{<>()}(<>{})>])]>}]{[[{<{[[<>[]]<<>{}>]{[{}()][{\n" +
                    "(({{[({<<({{[{<><>}(())][[()]<{}{}>]}{{[()[]]{{}{}}}[<[][]>{()()}]}}{{(<[]()><[][]>)([[][]]({}<>\n" +
                    "([{{([((([({{<[][]>[{}()]}{([]<>)<[]()>}}<{[()()]{<>()}}>)<<([<><>](()()))[(()())<(){}>]>>]){[\n" +
                    "[((({([(<{[({{<>()}{[]}}{([]<>](<>[])}){[(()[])[[]]][([][])[<>]]}]{<<{[]()}(<>{})><{{}[]}[<>(\n" +
                    "<{{(<<{<((([[{<><>>]<[{}<>]((){})>]{[[()<>]{{}()}]<{[]}<<>()>>})<<[[[][]]{[][]}]{{{}[]}<()\n" +
                    "<({(<({({[(<[[<>{}]<<>[]>]>(<[[]()][()()]>{<(){}>[[][]]>)){<{{{}}}<({})<{}()>>>{{{()<>}<[]<>>}(<()\n" +
                    "({<<([<<<[{<([[][]]{[]<>})<<<>{}>((){})>>}{{<(<>[])[<>()]><([][])(()())>}[[{[]<>}{()()}]{({}{}){{}{}}}]}]{{(\n" +
                    "{{{<{[({[[<[([()[]])<<{}[]>{()[]}>]>]((<({<>()}<[]<>>)[{<>[]}]>[{[()<>]<<>>}<{()()}{{}[]}>\n" +
                    "({<[[<<([<{{[<[][]>{{}{}}]{[[]()][[]()]}}<{{{}{}}<{}[]}}[{()<>}(()[])]>}[([(<>())]){(<[]()><<>()>)}]\n" +
                    "{<{((<<{<({<<{{}<>}{<>[]}>[{[]<>}{()}]>([(<>[]){{}{}}][[<>{}](<><>)])}[(<[[][]]({}[])><<<>{}]>){<[{}[]]<\n" +
                    "(([<[<{<({<[{[()()]<{}<>>}{<<><>>{()<>}}]{{(()[])[[]<>]}<({}{})<{}[]>>}>({({<><>}[{}<>])(<()<>>)}[(<{}(\n" +
                    "[{<<<<[[{{<{([[]()]<[]<>>)}>{<({()()}<{}[]>)>[{{[][]}[{}<>]}({<><>}(<>()))]}}{[[{<<>{}>><([]())(()\n" +
                    "{([(<{{[{{[((<[]()>[{}<>])(<{}<>>[(){}>))]([<<[]<>>[<>[]]>{{[][]}{{}{}}}]{<({}{}){<>[]}>([<>\n" +
                    "[<{[{(((({<[{{{}{}}[[]<>]}[{[]<>}<(){}>]]<{({}())[()<>]}<<[]()>([][])>>>([<<()[]><()<>>>]<([()<>][<>[]\n" +
                    "{<{[{<<{<<{(((<><>)[[]()]){({})<[]()>})[[<<>{}>(<>())]<(()<>){[]()}>]}{{<({}[]){(){}}>{[()<>]({}{})}}}>>[[\n" +
                    "(({<<{{<[<<<<[[]<>]<[]{}>>[((){})({}[])]>[<(<>())([]{})><[{}<>][[]{}]>]>((([<>[]]<<>[]>)([<><>][[][]]}))>][(<\n" +
                    "[[{<{{{(([{({([]<>)[<>[]]}{[[]<>][()<>]}){{<<>()>([]{})}[{<>()}(<><>)]}>(([<[]<>>[()()]]{[[]{}]{{}<>}}){(\n" +
                    "((<[[([{<<{{{([]{}){<>{}}}({<><>}{{}{}})}<<<[]{}>(<>[])>([()<>])>}{<([(){}]({}[]))[({}<>)((){})]>[[<<\n" +
                    "[[{<[((<[<{(([[]()][[][]]))}>]><[{([(<[][]>{(){}})<{{}[]}[{}{}]>])((<<{}()>[[][]]>{{()[]}((){})\n" +
                    "{{{[(({{<<{({<{}<>><[]{}>}[<{}<>>({}[])])}>>{{{((<[]()>[(){}]))({<[][]>[<>[]]}[[<><>](()[])\n" +
                    "<<((<({{{{<({({}()){<>()}}<[<>()]>){([[]<>]([]<>))[[()<>]]}>]{[({[{}()]{[][]}})({[[]()]{()()}}[(()[\n" +
                    "[{<{{{[<[<<{{(()())({}{})}(<<><>>[[]<>])}><[<[<><>]<{}<>>>([[]()}{[][]})]>>[[{<[[]<>]<<>{}>><<(){}>{[]\n" +
                    "<<[<<[[(([({[{()[]}{<>}]<(()())[[]()]>}<((<><>)<[]()>]{(<><>){(){}}}>)])({[<<([]{})<{}[]>>[[{}[]](<>\n" +
                    "<[{{{<<<{<{({<{}[]>[<><>]})}<{([[]<>]([]<>))<[()<>]({}{})>}{{[{}()]({}<>)}}>>}<<((<{<><>}[()<>]>\n" +
                    "({([{(((((([[<[]{}>((){})]<[()<>]<{}()>)]))[(<<([]()){[]<>}>[({}[])<{}{}>]><[[<>]{{}()}]<(()<>)[{}()]>>)]))<<\n" +
                    "<[[<((([<[(((([][]){{}<>})(<<>()>{<>()}))<[[(){}]<{}()>]<{()<>}[<>]>>)<([<[]{}>[{}]]){<{{}{}}>(<<>()>{[]<>})}\n" +
                    "({({(<(({([{{<<>()>}[<{}{}><{}{}>]}[(<[][]>[()()]){([]{})[<>[]]}]])})){<{(<(<{<>()}>)[[{<>()]<()[]\n" +
                    "(<<<{{{{({[<{<()>[[]()]}<[<>]>>][{([()<>](()())){(<>())[<>[]]}}<{{()()}({}<>)}{[<><>]}>]}(<{[(()<>){()[]\n" +
                    "<{[([({{[{({{[<>()]<<>{}>}([[]()]([]<>))}<<{<><>}>[([]<>)([]{})]>)(<[{[]<>}(<>[])]>[([()[]][{}()])[[{\n" +
                    "[<<<(({<{{[<<([]<>)((){})>{(()()){<>{}}}>{[{[]()}<<>{}>]}]<<[{()<>}((){})}>[[(<>{})]]>}<{[<{<>{}}(())\n" +
                    "[([({([<<{<[<<{}()>{<><>}>{<()[]>}]>([([[]()]([]{}))([[][]]{[]()})])}<{{(<[]{}>{()<>})<(<><>)<[\n" +
                    "[({(<<{(<[[{<{<><>}<()[]>>}[<[[]{}][[][]]>(<<><>>{<>{}})]]<{{[<>]<()<>>}[([][])[<>()]]}<((()\n" +
                    "<([[{(({[[<<((()[]){<>()})[<<><>]{()()}]>[[(()[]){{}<>}]{[()[]](()())}]>[(<[{}{}]<<>[]>><({}())>)({[()]})]]]}\n" +
                    "[(<<<{(({({<[((){}}({}())]<<{}{}>((){})>>}<{<([]{})>({<>}<{}[]>)}[<<[]<>>[()()]><(()())[<>()]>]>){[{(\n" +
                    "{<[[[{{<[{{{<<(){}>{[]<>}>[<(){}>({}[])]}<(<<>{}>)({()()})>}<([([][])<{}<>>]<{()[]}(<>())>)[([()<\n" +
                    "(<<(<{[[(<{<<[()()]([]<>)>{<{}{}>([]{})}>}[([(<>{})[()()]][([]())[<>[]]]){([{}<>]{()[]})(<()[]>)}]>)]]\n" +
                    "{<([[(<((<({{<(){}>([])}<[{}()][()<>]>}[[(()())]<[<>[]]((){})>])>([(<<[]><[][]>><({}{})[<>[]]>)])){{({[[[]<\n" +
                    "[[[<<{([[{[(<<{}<>>>)]}<<<{{<>()}<<><>>}{[{}[]]{<>{}}}>>>][<{{{<[][]>[<>()]}[([]<>){{}<>}]}<({[](\n" +
                    "({{({<<(<(([{{{}[]}([]<>)}{[()[]]([]<>)}]([{{}[]}<{}()>]{{{}<>}{<>[]}}))(<{<<>{}>}[{<>()}[<>[]]]>{(<()()>({}\n" +
                    "{{<<{{({{[{<(<{}<>>){{{}<>}<()[]>}>}](<[[<{}[]><[][]>][(()())([]())]]({{{}{}}<(){}>}{{(){}\n" +
                    "[{[<<{{[(<([[[{}{}]<()[]>]{((){})[{}()]}][(<[][]>{()})[<[]()>[[]{}]]>)>(<[<[[]()]<<>[]>>][[({}[])<\n" +
                    "[[<<[{<<{{{<[{<><>}][{()[]}]>[(<<>{}><<>()))[[<><>]([]<>)]]}}}>[{<[{<([]{}){[]<>}>({(){}}{[]{}})}]([[(\n" +
                    "[<([[<{<<([([(()())(()())])((((){})[[]{}]))][{[[[]()]]}]))>}>](<{({{(<{({}[]){[]{}}}<{{}[]}[{}[]]>\n" +
                    "({<<{{<{(({[<([]())({}[])>(<<>[]><[]<>>)]{[([]<>){{}<>}][{{}()}<[]<>>]}})([({<[]()>{{}}]{<\n" +
                    "<{{{{[<{[<([[({}{})<<>()>]{{()()}[{}{}]}][{[<><>](<>())}[[<><>][{}{}]]])(<({<>})>[<[{}{}]{\n" +
                    "{[[[([[[{(<<{(<>[])[{}[]]}{<<>{}>(<>())}>({<()()>[{}[]]}(<{}[]>[[]<>]))>)}]{[{({(<{}{}>)<(()\n" +
                    "{[(<{{[(<((<([<><>]{()[]})<{[]<>}(()<>)>><[(()())]<[()()][<>{}]>>))>)(<([[({[]<>}{()[]})({[]()}[{}()])]<<{\n" +
                    "[{{<[{[[<<<<{(<>()){()()}}[({}())((){})]>((([]{})))><<[(<>[]){{}[]}][{{}{}}(()<>)]><[{[]{}}[[]{\n" +
                    "[[<{<(<[([<[(<<><>>[{}<>])[<()()>{<>[]}]]{({{}()}{<>[]})({()<>}[{}<>])}>(([[{}{}]<(){}>]{{()()}\n" +
                    "({<([[{{<<{<<[[]{}]((){})>[{<>()}[[]()]]>[[[[]()][[]{}]][<(){}>(<>())]]}(<{[{}()]{{}()}}{{{}\n" +
                    "{{<<<(<{<[<[({{}{})<{}<>>)<{<><>}<()[]>>]{<(()())[{}]>}><<([<>{}]((){}))<[()[]]<<>()>>>(<{<>()}[<><>]>\n" +
                    "<([{{{((((<[[<{}[]>{<><>}]<[()]<<>{}>>]<<<[][]>[[]<>]>[(()[]){()[]}]>>){[[([<>{}][<>{}])(([]\n" +
                    "([(({{<<(({(({()}{{}()>))([(<>{})]<({}[]){<>()}>)}{<{{()()}<()<>>}<<[][]>(<>())>>})([[{[[]()]<<>\n" +
                    "{[<(<{<({{({((<><>))[[[]{}]{[][]}]}<({{}<>}[[]<>]]<(()<>)<{}()>>>)}})[{{([{(<><>)[<>{}]}[[{}()]]]{[<\n" +
                    "[<(<<[(({([[<<[][]><{}()>><{<><>>[<>[]]>]]((<(<>[]){<>{}}>{{()[]}(<>[])})))<((((()[])[()<>])))"
        )
    }
}
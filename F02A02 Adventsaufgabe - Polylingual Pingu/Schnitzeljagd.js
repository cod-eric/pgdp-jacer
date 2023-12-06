function fun() {


    //A1
    console.log(null > 0);      // false
    console.log(null == 0);     // false
    console.log(null >= 0);     // true ??


    //A2
    console.log("0" == 0)       // true ??
    console.log([] == 0)        // true ??
    console.log("0" == [])      // false ??


    // A3
    console.log(NaN ** 0)         // 1 ??


    // A4
    console.log("2" + 1)        // 21 ??


    // A5
    console.log("2" - 1)        // 1 ??


    // A6
    console.log(9999999999999999)       // 10000000000000000 ??


    // A7
    console.log(0.1 + 0.2)              // 0.30000000000000004 ??


    // A8
    console.log(('b' + "a" + +'b' + `a`).toLowerCase())      // banana ??


    // A9
    let solution = ""   // .concat konkateniert, d.h. hängt hinten an einen String an

    let m = null
    let n = "e!="

    if (!solution && !m) {
        .1 < 1 && (solution += "t")
    } else if (true > false) {
        solution = solution.concat("n")
    } else {
        solution = solution.concat("s")
    }

    if (324) {
        solution = solution.concat("r")
    }

    if(0){
        solution = solution.concat("a")
    }

    if (n += m > 2) {
        solution = solution.concat("u")
    }

    0 || (solution = solution.concat(n));
    console.log(solution)           // true!=false ??


    // A10
    let sr
    let st = 1 / 0
    let stt = (![] + [])[+[]] + (![] + [])[+!+[]] + ([![]] + [][[]])
        [+!+[] + [+[]]] + (![] + [])[!+[] + !+[]];
    console.log("PGdP is not (?) an " + sr + " "+ st + " " + stt)        // PGdP is not (?) an undefined Infinity fail ??
}

fun()

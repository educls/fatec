var matriz2x2 = [
    [43, 24],
    [22, 44]
];

var a00 = matriz2x2[0][0]
var a11 = matriz2x2[1][1]
console.log("a00 = ",a00, "\na11 = ",a11)

var a01 = matriz2x2[0][1]
var a10 = matriz2x2[1][0]
console.log("a01 = ",a01, "\na10 = ",a10)

determinante = ((a00 * a11) - (a01 * a10))


console.log(`Determinante2x2 = ${determinante}`)




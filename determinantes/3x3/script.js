var a3x3 = [
    [3, 4, 3],
    [2, 4, 1],
    [8, 2, 6]
];

var Determinante3x3 = 
  (a3x3[0][0] * a3x3[1][1] * a3x3[2][2]) 
+ (a3x3[1][0] * a3x3[2][1] * a3x3[0][2]) 
+ (a3x3[2][0] * a3x3[0][1] * a3x3[1][2])
- 
  (a3x3[0][2] * a3x3[1][1] * a3x3[2][0]) 
+ (a3x3[1][0] * a3x3[0][1] * a3x3[2][2]) 
+ (a3x3[1][2] * a3x3[2][1] * a3x3[0][0])

console.log(`Determinante3x3 = ${Determinante3x3}`)
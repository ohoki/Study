//단항 연산자(Unary Operators)

//+(양)
//-(음)
//!(부정)
//!!(값을 bollean 타입으로 변환)

let a = 5;
a = -a; // -1*5
console.log(a); //-5
console.log(-a); //5

let boolean = true;
console.log(boolean); //true
console.log(!boolean); //false
console.log(!!boolean); //true

//+ (숫자가 아닌 타입) -> 숫자로 변환하면 어떤값이 나오는지 확인할 수 있음
console.log(+false); //0
console.log(+null); //0
console.log(+''); //0
console.log(+true); //1
console.log(+'text'); //NaN
console.log(+undefined); //NaN

console.log(!1); //false (1은 true이나 !로 부정해서 false 값이 나옴)


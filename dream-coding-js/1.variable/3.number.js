//데이터 타입 - 숫자열

// 정수, 음수, 실수, 2진수, 8진수, 16진수 전부 다 변수 데이터로 사용 가능

let integer = 123; //정수
let negative = -123; //음수
let double=1.23; //실수
console.log(integer);
console.log(negative);
console.log(double);

let binary = 0b1111011; //2진수
let octal = 0o173; // 8진수
let hex = 0x7b; // 16진수
console.log(binary);
console.log(octal);
console.log(hex);

//큰 정수를 쓸 땐 뒤에 n을 붙여야 함

let bigInt = 1234567890123456789012345678901234567890n; 
console.log(bigInt);


//숫자를 나눌 때 발생할 수 있는 데이터 값들

console.log(0 / 123); //0
console.log(123 / 0); //Infinity
console.log(123 / -0); //-Infinity
console.log(123 / 'text'); //NaN (Not a Number)
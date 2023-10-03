// while(조건) {}
// 조건이 false가 될때까지 {} 코드를 반복 실행

let num = 5;
while (num >= 0) {
  console.log(num);
  num--;
}
//num--;이 없으면 무한반복 됨

let isActive = true;
let i = 0;

while(isActive) {
  console.log('아직 살아있다!');
  if (i === 1000) {
    break;
  }
  i++;
}

do {
  console.log('아직 살아있다!');
} while(isActive);

//조건이 맞을때만 실행하고 싶으면 while,
//꼭 한번은 실행해야한다면 do while을 사용


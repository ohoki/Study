// return을 정의하지 않으면 자동으로 undefined이 반환됨!
function add(a, b) {
  return; //undefined
}
const result = add(1, 2); //undefined
console.log(result); //undefined

//함수에서 값을 리턴해야 하는 함수가 아니라면 굳이 return undefined;를 작성할 필요가 없음
function print(text) {
  console.log(text);
}
print('text'); //text

//return을 함수 중간에 하게 되면 함수가 종료됨
//사용예: 조건이 맞지 않는 경우 함수 도입부분에서 함수를 일찍이 종료함!

function print(num) {
  if (num < 0) {
    return; 
    //함수를 즉시 종료 return undefined와 같음 (일찍 함수를 종료하는 용도)
  }
  console.log(num);
}
print(12);
print(-12);


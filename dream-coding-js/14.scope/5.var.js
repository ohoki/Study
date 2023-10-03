// var의 특징 (안좋아서 안씀)
// 일반 코딩 방식과 어긋나서 개발하면서도 멘붕이 옴
// 코드의 가독성과 유지보수성에 좋지 않음

//1. 변수 선언하는 키워드 없이 선언 & 할당이 가능함
// 선언인지, 재할당인지 구분하기가 어려움
something = '😱';
console.log(something);

//2. 중복 선언이 가능하다 (오류 발생 가능성)
var poo = '😱';
var poo = '😱';
console.log(poo);

//3. 블록 레벨 스코프가 안됨 !!
var apple = '사과';
  {
    var apple = '🍎';
  }
console.log(apple);
//원래라면 사과 가 출력되는게 맞지만 var를 사용할 경우 🍎이 출력됨

//4. 함수 레벨 스코프만 지원 됨
function example() {
  var dog = '개';
};
console.log(dog); //error - dog is not defined

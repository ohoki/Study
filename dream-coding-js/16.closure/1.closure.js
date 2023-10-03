const text = 'hello';
function func() {
  console.log(text);
};
func();
// 그 어떤 블록에서든지 내부에서 외부로의 접근은 가능하다.
// 하지만 외부에서 내부로의 접근은 불가능하다.

//내부에서 외부를 접근할 수 있다고 해서 다 클로저라고 부르진 않고
//중첩된 함수에서 내부에서 있는 함수와 외부에 있는 함수의 렉시컬 환경이
//포함 관계로 저장되어 내부함수에서 외부 렉시컬 환경으로 접근하는 것을 클로저라고 함

function outer() {
  const x = 0;
  function inner() {
    console.log(`inside inner: ${x}`);
  };
  inner();
};
outer();

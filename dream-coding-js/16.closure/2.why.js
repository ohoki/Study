// 클로저는 내부 정보를 은닉하고, 공개 함수를 통한 데이터 조작을 위해 쓰임
// 캡슐화와 정보은닉을 위해 사용!
// 클래스 private 필드 (클래스 내부 변수=field) 또는 메소드를 사용하는 효과와 동일
function makeCounter() {
  let count = 0;
  function increase() {
    count++;
    console.log(count);
  };
  return increase;
};

const increase = makeCounter();
increase();
increase();
increase();

//하지만 클래스를 사용하면 클로저가 필요없음..

class Counter {
  #counter = 0;
  increase() {
    this.#counter++;
    console.log(this.#counter);
  };
};
const counter = new Counter();
counter.increase();
counter.increase();
counter.increase();
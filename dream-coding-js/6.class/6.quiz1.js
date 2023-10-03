//카운터를 만들기
//0 이상의 값으로 초기화 한 뒤 하나씩 숫자를 증가할 수 있는 카운터를 만들기
//Counter 클래스 만들기

//클래스를 만들기 전에 내가 출력하게 될 결과물들을 한번 만들어 보기

// const counter = new Counter (0);
// counter.increament(); //1
// counter.increament(); //2
// console.log(counter.value);

class Counter {
  #value;
  constructor(startValue) {
    if (isNaN(startValue) || startValue < 0) {
      this.#value = 0;
    } else {
      this.#value = startValue;
    }
  }
  get value() {
    return this.#value;
  }
  increament = () => {
    this.#value++;
  }
}

const counter = new Counter(-1);
counter.increament();
counter.increament();
console.log(counter.value);

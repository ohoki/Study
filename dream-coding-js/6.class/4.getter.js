//게터와 세터 - 접근자 프로퍼티 (Accessor Property) 
//변수처럼 보이지만 실제로 함수를 뜻함

class Student {
  constructor(firsName, lastName) {
    this.firsName = firsName;
    this.lastName = lastName;
  }
  get fullName() {
    return `${this.firsName} ${this.lastName}`;
  }

  set fullName(value) {
    console.log('set', value);
  }
}

const student = new Student('영호', '최');

// console.log(student.fullName());

//fullName을 프로퍼티 처럼 만들어서 호출하게 되면 그 이후 업데이트가 되지 않기에
//firsName이나 lastName을 변경해도 fullName은 변경되지 않음
//그래서 fullName을 함수로 만들어서 호출해야 됨! 
//하지만 나는 함수로 호출하기 싫다! 그냥 프로퍼티처럼 호출하고 싶다!! 라고 할 때
//사용하는 것이 접근자 프로퍼티 (Accessor Property)이다.

console.log(student.fullName);
//dot notation으로 값을 읽게 되면 get이 호출되고
student.fullName = '김철수';
//무언갈 할당한다면 set이 호출된다.
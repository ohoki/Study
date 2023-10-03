//코딩할 때 중요한 컨셉 Immutability (불변성)
//불변성을 유지하며 코딩하는게 중요하다!!

const value = 4;

function display(num) {
  num = 5;     // ❌
  console.log(num);
}

display(value);
console.log(value);
//함수내부에서 외부로 주어진 인자의 값을 변경하는 것은 매우 좋지 않다 ❌
//상태변경이 필요한 경우에는, 새로운 상태(오브젝트, 값)를 만들어서 반환해야 함!!

//원시값은 값에 의한 복사의 경우 value의 값이 변경되지는 않았지만 
//객체값은 참조값에 의한 복사(메모리주소)이기 때문에 함수의 name이 변경되어 버림
//그렇기 때문에 고차함수의 경우 내부에서 값을 변경하게 되면 문제가 생길 수도 있다!!

function displayObj(obj) {
  obj.name = 'Bob';  
  //❌❌❌ 외부로 부터 주어진 인자(오브젝트)를 내부에서 절대 변경해선 안됨!! ❌❌❌
  console.log(obj);
}

const youngho = { name: 'Youngho' };

displayObj(youngho); // Bob 출력
console.log(youngho); // Bob이 출력됨 (함수의 정의값이 변경됨!!)


//부득이하게 변경해야 하는 경우에는
function changeName(obj) {        //변경되는 느낌의 함수 이름 정의!!
  return {...obj, name: 'Bob'};   //반환할 때는 새로운 오브젝트 만들기!!
}


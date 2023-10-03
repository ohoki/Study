function getBanana() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve('🍌');
    }, 1000)
  });
};

function getApple() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve('🍎');
    }, 3000)
  });
};

function getOrange() {
  return Promise.reject(new Error('no orange'));
};

//바나나와 사과를 같이 가지고 와서 배열로 정리
getBanana()
.then((banana) => 
  getApple()
  .then((apple) => [banana, apple])
  ).then(console.log)
  
  //[ '🍌', '🍎' ]

  //Promise.all 병렬적으로 한번에 모든 Promise들을 실행!!
  Promise.all([getBanana(), getApple()]) //배열로 정렬됨
  .then((fruits) => console.log('all', fruits));

  //Promise.race 주어진 Promise중에 제일 빨리 수행된 것이 이김!
  Promise.race([getBanana(), getApple()])
  .then((fruits) => console.log('race', fruits));

  Promise.all([getBanana(), getApple(), getOrange()])
  .then((fruits) => console.log('all-error', fruits))
  .catch(console.log); //error

  Promise.allSettled([getBanana(), getApple(), getOrange()])
  .then((fruits) => console.log('all-settled', fruits))
  .catch(console.log);
  /**
   * all-settled [
    { status: 'fulfilled', value: '🍌' },
    { status: 'fulfilled', value: '🍎' },
    {
      status: 'rejected',
      reason: Error: no orange
   */
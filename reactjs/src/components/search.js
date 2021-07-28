import React from "react";


const data = [
    { id: 1, name: "Siva", age: 20 },
    { id: 2, name: "Raja", age: 25 },
    { id: 3, name: "Rama", age: 40 },
    { id: 4, name: "Raghu", age: 30 }
  ];

const testFun = (inputData) =>{
    return inputData.reduce((sum,item) => (sum+item.age),0);
}

export default function SearchList() {
    
  let result = data.filter(item => item.age >25);
  let check = result;
  console.log(result);
  console.log(testFun(data));

  let reduceResult = data.reduce((sum,item)=>(sum+item.age),0)
  console.log(reduceResult)
  console.log(data.splice(2,1));

  const array = [ 23, 45, 67, 89, 12 ]
  const largerThanSixty = array.filter( number => {
    return number > 60
  })

  return (
      <div>
          {data.filter((item) => item.name.match("Siva"))
                .map(filteredItem =>(
                    <li> {filteredItem.name} </li>
                ))
            }
            
                
         <h1>Test Search -  {result.sort}</h1>

         <ul> Number greater than 60:
            { largerThanSixty.map(number => <li>{number}</li>) }            
        </ul>

        <ul> Data by filter:
            { result.map(filterData => <li>{filterData.name}</li>) }
        </ul>

        {
            data.sort((a,b) => (a.name.toUpperCase() > b.name.toUpperCase() ? 1 : -1)).map(
                filterData => <li>{filterData.name}</li>
            )
        }

      </div>
    );
}

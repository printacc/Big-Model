//  SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;
contract structTest{
    struct   stu{
        uint ids;
        string names;
        mapping (uint=>string) map;
    }
    stu nad;
    function getSturct(uint id,string memory name,string memory nam)public {
        stu storage s1 = nad;
        s1.ids=id;
        s1.names=name;
        s1.map[id]=nam;
        
    }
     //如何struct里有mapping或strct本身定义的值如stu则需要在两个函数里进行才能获取到正确的值不然会报对于存储结构体实例，您无法在视图函数中修改结构体的状态。
    function getnadd()public view  returns (uint,string memory,string memory){
        return (nad.ids,nad.names,nad.map[1]);
    }

}
//可行的方法


// pragma solidity ^0.8.0;
// //ai生成的
// contract structTest {
//     struct stu {
//         uint ids;
//         string names;
//     }

//     mapping(uint => stu[])  s;

//     function setStruct(uint id, string memory name) public {
//         stu memory s1 = stu({ids: id, names: name});
//         s[id].push(s1);
//     }

//     function getStruct(uint id) public view returns (stu[] memory) {
//         return s[id];
//     }
// }
// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract demo1{

    struct student{
        uint grade;
        string name;
    }

        student stu;
    
    function test(student storage s) internal {
        student storage meimei = s;
        meimei.name = "yangjinlong";
    }

    function ca11()public  returns(string memory){
        test(stu);
        return stu.name;
    }
        

}

contract demo2{

    struct student{
        uint grade;
        string name;
    }

        student stu;
        student tmp;
        student[] students;
    function test(student storage s) internal {
         student storage ad = s;
         students.push(ad);
         stu=s;
        s.name = "yangjinlong";
        //当s传递给是将结构体复制给另一个变量，并不是将地址指向对方所以并不会stu造成后续的影响如何想有影响则需要将student stu改成student storage stu，暂时我还改不了
    }

    function ca11()public  returns(string memory){
        tmp = student(100, "tmp");
        test(tmp);
        return students[0].name;
    }
}

contract demo3{

    struct student{
        uint grade;
        string name;
    }

        student stu=student(100,"houres");
    
    function test(student storage s) internal {
        student memory meimei = s;
        meimei.name = "yangjinlong";
    }

    function ca11()public  returns(string memory){
        test(stu);
        return stu.name;
    }

}

contract demo4{

    struct student{
        uint grade;
        string name;
    }

    function test(student memory s) internal {
        student memory link = s;
        link.name = "yangjinlong";
    }

    function ca11()public  returns(string memory){
        student memory meimei =student(100,"muses");
        test(meimei);
        return meimei.name;
    }

}
contract demo5{

    struct student{
        uint grade;
        string name;
    }

        student  stu;
        student tmp;
       
    function test(student storage s) internal {
         stu=s;
        s.name = "yangjinlong";
     }

    function ca11()public  returns(student memory){
        tmp = student(100, "tmp");
        test(tmp);
        return stu;
    }
}

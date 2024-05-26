package com.example.mybatisdemo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NameService {

    //field
    private NameMapper nameMapper;
    //constructor
    public NameService(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    //method
    //１つの業務処理あたり１つのメソッド
    //メソッド内から別のメソッドを呼び出さないようにしましょう（コーディングのルール/会社による）
    public List<Name> findNamesStartingWith(String prefix) {
        return nameMapper.findByNameStartingWith(prefix);
    }

    public Name findName(int id){
        Optional<Name> name = nameMapper.findById(id);
        if(name.isPresent()){
            return name.get();
        } else {
            throw new NameNotFoundException("name not found");
        }
    }


}

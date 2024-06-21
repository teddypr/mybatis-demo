package com.example.mybatisdemo.service;

import com.example.mybatisdemo.NameNotFoundException;
import com.example.mybatisdemo.entity.Name;
import com.example.mybatisdemo.mapper.NameMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NameServiceTest {

    //Mockito
    //スタブ、モック

    @InjectMocks
    private NameService nameService;

    @Mock
    private NameMapper nameMapper;

    @Test
    public void 指定したIDの名前を取得できること() {

        //テスト対象のクラスをインスタンス化
        //スタブの設定
        doReturn(Optional.of(new Name(1, "Alice"))).when(nameMapper).findById(1);

        //テスト対象のメソッドを実行
        Name actual = nameService.findName(1);

        //実行結果を検証
        assertThat(actual).isEqualTo(new Name(1, "Alice"));

        //スタブの呼び出しを検証 times は呼び出す回数
        verify(nameMapper, times(1)).findById(1);

    }

    //例外をthrowする場合の検証はどう書くのか　assertThatThrowBy　DoNothing
    @Test
    public void 存在しないIDを指定した場合は例外が発生すること() {
        doReturn(Optional.empty()).when(nameMapper).findById(1);
        assertThatThrownBy(() -> {
            nameService.findName(1);
        }).isInstanceOf(NameNotFoundException.class)
                .hasMessage("name not found");
    }

}

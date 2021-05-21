package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.dao.mapper.MouldMapper;
import cn.edu.usts.cs2018.entity.Mould;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "mouldService")
public class MouldServiceImpl implements IMouldService {
    @Autowired
    MouldMapper mapper;
    @Override
    public Boolean insert(Mould mould) {
        return mapper.insert(mould)>0;
    }

    @Override
    public Boolean update(Mould mould) {
        return mapper.update(mould)>0;
    }

    @Override
    public Boolean delete(int id) {
        return mapper.delete(id)>0;
    }

    @Override
    public Mould getMould(int id) {
        return mapper.getMould(id);
    }

    @Override
    public List<Mould> getMoulds() {
        return mapper.getMoulds();
    }
}

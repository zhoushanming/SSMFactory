package cn.edu.usts.cs2018.dao.mapper;

import cn.edu.usts.cs2018.entity.Mould;

import java.util.List;

public interface MouldMapper {
    public int insert(Mould mould);
    public int update(Mould mould);
    public int delete(int id);

    public Mould getMould(int id);
    public List<Mould>getMoulds();
}

package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.entity.Mould;

import java.util.List;

public interface IMouldService {
    public Boolean insert(Mould mould);
    public Boolean update(Mould mould);
    public Boolean delete(int id);

    public Mould getMould(int id);
    public List<Mould> getMoulds();
}

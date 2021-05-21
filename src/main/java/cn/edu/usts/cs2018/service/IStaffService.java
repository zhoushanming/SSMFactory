package cn.edu.usts.cs2018.service;


import cn.edu.usts.cs2018.entity.Staff;

import java.util.List;

public interface IStaffService {
    public Boolean insert(Staff staff);
    public Boolean update(Staff staff);
    public Boolean delete(int id);

    public Staff getStaff(int id);
    public Staff getStaffByName(String name);
    public List<Staff>getStaffList();

    public Boolean login(String name,String password);
}

package cn.edu.usts.cs2018.dao.mapper;

import cn.edu.usts.cs2018.entity.Staff;

import java.util.List;

public interface StaffMapper {
    public int insert(Staff staff);
    public int update(Staff staff);
    public int delete(int id);

    public Staff getStaff(int id);
    public Staff getStaffByName(String name);
    public List<Staff>getStaffList();
}

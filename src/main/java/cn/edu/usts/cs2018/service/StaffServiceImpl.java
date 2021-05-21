package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.dao.mapper.StaffMapper;
import cn.edu.usts.cs2018.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="staffService")
public class StaffServiceImpl implements IStaffService {

    @Autowired
    StaffMapper mapper;
    @Override
    public Boolean insert(Staff staff) {
        return mapper.insert(staff)>0;
    }

    @Override
    public Boolean update(Staff staff) {
        return mapper.update(staff)>0;
    }

    @Override
    public Boolean delete(int id) {
        return mapper.delete(id)>0;
    }

    @Override
    public Staff getStaff(int id) {
        return mapper.getStaff(id);
    }

    @Override
    public Staff getStaffByName(String name) {
        return mapper.getStaffByName(name);
    }

    @Override
    public List<Staff> getStaffList() {
        return mapper.getStaffList();
    }

    @Override
    public Boolean login(String name, String password) {
        return mapper.getStaffByName(name).getPassword()==password;
    }
}

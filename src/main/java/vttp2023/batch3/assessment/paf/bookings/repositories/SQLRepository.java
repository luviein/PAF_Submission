package vttp2023.batch3.assessment.paf.bookings.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import vttp2023.batch3.assessment.paf.bookings.models.Bookings;

@Repository
public class SQLRepository {

    @Autowired
    JdbcTemplate template;
    
    private final String FINDVACANCYBYID = "select vacancy from acc_occupancy where acc_id = ?";
    private final String INSERT_TO_RESERVATIONS = "insert into reservations(resv_id, name, email, acc_id, arrival_date, duration) values(?,?,?,?,?,?)";
    private final String UPDATE_VACANCY = "update acc_occupancy set vacancy = 98 where acc_id = ?";

    public Integer findVacancyById (Integer id) {
        List<Integer> vacancy = template.query(FINDVACANCYBYID, BeanPropertyRowMapper.newInstance(Integer.class), id);
        return vacancy.get(0);
    }

    public Boolean insertReservation (Bookings bookings) {
        PreparedStatementCreator psc  = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(INSERT_TO_RESERVATIONS);
                
                ps.setInt(1, Integer.parseInt(UUID.randomUUID().toString().substring(0, 8)));
                ps.setString(2, bookings.getName());
                ps.setString(3, bookings.getEmail());
                ps.setInt(4, bookings.getId());
                
                return ps;
            }
            
            
        };

        template.update(psc);
        return true;
        
    }

    public Boolean updateVacancy (Integer id) {
        PreparedStatementCreator psc  = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(UPDATE_VACANCY);
                
                // ps.setString(2, bookings.getName());
                // ps.setString(3, bookings.getEmail());
                // ps.setInt(4, bookings.getId());
                
                return ps;
            }
            
            
        };

        template.update(psc);
        return true;
        
    }


}

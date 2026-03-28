package com.api.rewards.service;

import com.api.rewards.dto.ReportDto;
import com.api.rewards.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final SaleRepository saleRepository;

    public ReportService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<ReportDto> getReport(LocalDateTime start, LocalDateTime end) {
        List<Object[]> rows = saleRepository.aggregateByProduct(start, end);
        return rows.stream()
                .map(r -> new ReportDto(
                        (String) r[0],
                        ((Number) r[1]).intValue(),
                        ((Number) r[2]).doubleValue()))
                .collect(Collectors.toList());
    }

    public byte[] exportCsv(LocalDateTime start, LocalDateTime end) {
        List<ReportDto> data = getReport(start, end);
        StringBuilder sb = new StringBuilder();
        sb.append("product,totalQty,totalAmount\n");
        data.forEach(d -> sb.append(escapeCsv(d.getProduct())).append(",")
                .append(d.getTotalQty()).append(",")
                .append(d.getTotalAmount()).append("\n"));
        return sb.toString().getBytes();
    }

    private String escapeCsv(String s) {
        if (s == null) return "";
        if (s.contains(",") || s.contains("\"") || s.contains("\n")) {
            return "\"" + s.replace("\"", "\"\"") + "\"";
        }
        return s;
    }
}
CREATE TABLE `cliente` (
`id` bigint(20) NOT NULL,
`nome` varchar(255) NOT NULL,
`vendedor` varchar(255) NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `vendedor` (
`id` bigint(20) NOT NULL,
`nome` varchar(255) NOT NULL,
`cliente` varchar(255) NOT NULL,

) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Indexes for table `empresa`
--
ALTER TABLE `cliente`
ADD PRIMARY KEY (`id`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
ADD KEY `FK4cm1kg523jlopyexjbmi6y54j` (`vendedor_id`);

--
-- Indexes for table `lancamento`
--
ALTER TABLE `vendedor`
  ADD PRIMARY KEY (`id`),
ADD KEY `FK46i4k5vl8wah7feutye9kbpi4` (`cliente_id`);

--
-- AUTO_INCREMENT for table `empresa`
--
ALTER TABLE `cliente`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `vendedor`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;


--
-- Constraints for table `funcionario`
--
ALTER TABLE `cliente`
ADD CONSTRAINT `FK4cm1kg523jlopyexjbmi6y54j` FOREIGN KEY (`vendedor_id`) REFERENCES `vendedor` (`id`);

--
-- Constraints for table `lancamento`
--
ALTER TABLE `vendedor`
ADD CONSTRAINT `FK46i4k5vl8wah7feutye9kbpi4` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);

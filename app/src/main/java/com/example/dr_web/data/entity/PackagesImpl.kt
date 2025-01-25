package com.example.dr_web.data.entity

import com.example.dr_web.domain.entity.Package
import com.example.dr_web.domain.entity.Packages

data class PackagesImpl(
    override val packages: List<Package>
): Packages